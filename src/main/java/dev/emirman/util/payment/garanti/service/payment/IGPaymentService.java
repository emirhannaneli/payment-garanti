package dev.emirman.util.payment.garanti.service.payment;

import dev.emirman.util.payment.garanti.config.store.GStoreConfig;
import dev.emirman.util.payment.garanti.exception.PaymentRequestSentFailed;
import dev.emirman.util.payment.garanti.model.payment.base.GPayment;
import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import dev.emirman.util.payment.garanti.model.payment.order.base.GOrder;
import dev.emirman.util.payment.garanti.service.installment.InstallmentService;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class IGPaymentService implements GPaymentService {
    private static final String GARANTI_3D_PAYMENT_URL = "https://sanalposprov.garanti.com.tr/servlet/gt3dengine";
    private static final String GARANTI_3D_PAYMENT_TEST_URL = "https://sanalposprovtest.garantibbva.com.tr/servlet/gt3dengine";
    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    private InstallmentService installmentService;

    public IGPaymentService() {
    }

    public IGPaymentService(InstallmentService installmentService) {
        this.installmentService = installmentService;
    }

    @Override
    public String pay(GPayment gPayment) {
        GStoreConfig config = gPayment.config();
        String mode = config.mode();
        String version = config.version();
        String terminalId = config.terminalId();
        String _terminalId = config._terminalId();
        String provUserId = config.provUserId();
        String provUserPass = config.provUserPass();
        String merchantId = config.merchantId();
        String storeKey = config.storeKey();
        String secure3DLevel = config.secure3DLevel();
        String companyName = config.companyName();
        String successUrl = config.successUrl();
        String failUrl = config.failUrl();


        GOrder order = gPayment.order();
        String orderId = order.orderId();
        String groupId = order.groupId();
        String currency = order.currency().getCode();
        String type = order.type().getValue();
        String lang = order.lang();

        String installments = installmentService == null ? "0" : order.installments();

        DecimalFormat df = new DecimalFormat("#0.00");
        String amount = installmentService == null
                ? df.format(order.amount())
                : installments != null && !installments.isBlank() && Integer.parseInt(installments) > 1
                ? df.format(installmentService.calculate(order.amount(), Integer.parseInt(installments)))
                : df.format(order.amount());
        amount = amount.replace(".", "");

        GCustomer customer = gPayment.customer();
        String email = customer.email();
        String ipAddress = customer.ipAddress();

        GCard card = gPayment.card();
        String cardHolderName = card.cardHolderName();
        String cardNumber = card.cardNumber();
        String cardExpireMonth = card.expireMonth();
        String cardExpireYear = card.expireYear();
        String cardCvc = card.cvc();

        String securityData = sha1(provUserPass + _terminalId);

        String hashData = sha1(terminalId + orderId + amount + successUrl + failUrl + type + installments + storeKey + securityData);

        Map<String, String> params = new HashMap<>();

        params.put("refreshtime", "0");
        params.put("secure3dsecuritylevel", secure3DLevel);
        params.put("txntype", type);
        params.put("cardname", cardHolderName);
        params.put("cardnumber", cardNumber);
        params.put("cardexpiredatemonth", cardExpireMonth);
        params.put("cardexpiredateyear", cardExpireYear);
        params.put("cardcvv2", cardCvc);

        params.put("companyname", companyName);
        params.put("apiversion", version);
        params.put("mode", mode);
        params.put("terminalprovuserid", provUserId);
        params.put("terminaluserid", terminalId);
        params.put("terminalid", terminalId);
        params.put("terminalmerchantid", merchantId);
        params.put("orderid", orderId);
        params.put("groupid", groupId);
        params.put("customeremailaddress", email);
        params.put("customeripaddress", ipAddress);
        params.put("txnamount", amount);
        params.put("txncurrencycode", currency);
        params.put("txninstallmentcount", installments);
        params.put("successurl", successUrl);
        params.put("errorurl", failUrl);
        params.put("lang", lang);
        params.put("txntimestamp", String.valueOf(System.currentTimeMillis()));
        params.put("txntimeoutperiod", "60");
        params.put("addcampaigninstallment", "N");
        params.put("totallinstallmentcount", installments);
        params.put("installmentonlyforcommercialcard", "N");
        params.put("secure3dhash", hashData);

        try {
            return sendRequest(params, mode).body();
        } catch (IOException | InterruptedException e) {
            throw new PaymentRequestSentFailed(e);
        }
    }

    private String sha1(String data) {
        return DigestUtils.sha1Hex(data).toUpperCase();
    }

    private HttpResponse<String> sendRequest(Map<String, String> params, String mode) throws IOException, InterruptedException {
        String data = params.entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .map(e -> e.getKey() + "=" + e.getValue())
                .reduce((a, b) -> a + "&" + b)
                .orElse("");

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mode.equals("PROD") ? GARANTI_3D_PAYMENT_URL : GARANTI_3D_PAYMENT_TEST_URL))
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Accept", "text/html")
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
    }
}
