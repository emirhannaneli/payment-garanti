package dev.emirman.util.payment.garanti.service.payment;

import dev.emirman.util.payment.garanti.model.payment.base.GPayment;
import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.model.payment.order.GOrder;
import dev.emirman.util.payment.garanti.config.GStoreConfig;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class IGPaymentService implements GPaymentService {
    private static final String GARANTI_3D_PAYMENT_URL = "https://sanalposprov.garanti.com.tr/servlet/gt3dengine";
    //private static final String GARANTI_XML_PAYMENT_URL = "https://sanalposprov.garanti.com.tr/VPServlet";

    private static final String GARANTI_3D_PAYMENT_TEST_URL = "https://sanalposprovtest.garantibbva.com.tr/servlet/gt3dengine";

    //private static final String GARANTI_XML_PAYMENT_TEST_URL = "https://sanalposprovtest.garantibbva.com.tr/VPServlet";

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    @Override
    public String createRequest(GPayment gPayment) throws IOException, InterruptedException {
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
        String amount = order.amount();
        String currency = order.currency().getCode();
        String type = order.type().getValue();
        String installments = order.installments();
        String lang = order.lang();

        GCustomer customer = gPayment.customer();
        String email = customer.email();
        String ipAddress = customer.ipAddress();

        GCard card = gPayment.card();
        String cardHolderName = card.cardHolderName();
        String cardNumber = card.cardNumber();
        String cardExpireMonth = card.expireMonth();
        String cardExpireYear = card.expireYear();
        String cardCvc = card.cvc();

        String securityData = sha1(provUserPass + _terminalId).toUpperCase();

        String hashData = sha1(terminalId + orderId + amount + successUrl + failUrl + type + installments + storeKey + securityData).toUpperCase();


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
        params.put("totallinstallmentcount", "0");
        params.put("installmentonlyforcommercialcard", "N");
        params.put("secure3dhash", hashData);

        String data = params.entrySet().stream()
                .filter(e -> e.getValue() != null && !e.getValue().isEmpty())
                .map(e -> e.getKey() + "=" + e.getValue())
                .reduce((a, b) -> a + "&" + b)
                .orElse("");

        URI uri = URI.create(mode.equals("PROD") ? GARANTI_3D_PAYMENT_URL : GARANTI_3D_PAYMENT_TEST_URL);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Accept", "text/html")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        return response.body();
    }

    private String sha1(String data) {
        return DigestUtils.sha1Hex(data);
    }
}
