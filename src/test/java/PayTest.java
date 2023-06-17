import dev.emirman.util.payment.garanti.config.GStoreConfig;
import dev.emirman.util.payment.garanti.model.payment.base.GPayment;
import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import dev.emirman.util.payment.garanti.model.payment.order.GOrder;
import dev.emirman.util.payment.garanti.model.payment.order.GOrderCurrency;
import dev.emirman.util.payment.garanti.service.payment.GPaymentService;
import dev.emirman.util.payment.garanti.service.payment.IGPaymentService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static dev.emirman.util.payment.garanti.model.payment.order.GOrderType.SALES;

public class PayTest {

    private static GStoreConfig devConfig() {
        return GStoreConfig.builder()
                .withMode("TEST")
                .withVersion("v0.01")
                .withSecure3DLevel("3D_FULL")
                .withProvUserId("PROVAUT")
                .withProvUserPass("123qweASD/")
                .withTerminalId("30691301")
                .withMerchantId("7000679")
                .withStoreKey("12345678")
                .withCompanyName("Hexcap")
                .withSuccessUrl("http://" + "localhost:3005" + "/v1/payment/callback")
                .withFailUrl("http://" + "localhost:3005" + "/v1/payment/callback")
                .build();
    }

    @Test
    public void pay() {
        GPaymentService paymentService = new IGPaymentService();
        GPayment gPayment = GPayment.builder()
                .withConfig(devConfig())
                .withOrder(GOrder.builder()
                        .withOrderId(UUID.randomUUID().toString())
                        .withGroupId(UUID.randomUUID().toString())
                        .withInstallments(0)
                        .withAmount(10.0)
                        .withCurrency(GOrderCurrency.TRY)
                        .withLang("tr")
                        .withType(SALES)
                        .build())
                .withCustomer(GCustomer.builder()
                        .withIpAddress("1.1.1.1")
                        .withEmail("test@test.com")
                        .build())
                .withCard(GCard.builder()
                        .withCardHolderName("Test Test")
                        .withCardNumber("4824892453725018")
                        .withCvc("567")
                        .withExpireMonth("01")
                        .withExpireYear("25")
                        .build())
                .build();
        try {
            String html = paymentService.pay(gPayment);
            assert html != null;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
