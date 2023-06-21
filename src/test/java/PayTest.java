import dev.emirman.util.payment.garanti.config.installment.InstallmentConfig;
import dev.emirman.util.payment.garanti.config.store.GStoreConfig;
import dev.emirman.util.payment.garanti.model.installment.Installment;
import dev.emirman.util.payment.garanti.model.payment.base.GPayment;
import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import dev.emirman.util.payment.garanti.model.payment.order.base.GOrder;
import dev.emirman.util.payment.garanti.model.payment.order.base.GOrderCurrency;
import dev.emirman.util.payment.garanti.service.installment.IInstallmentService;
import dev.emirman.util.payment.garanti.service.installment.InstallmentService;
import dev.emirman.util.payment.garanti.service.payment.GPaymentService;
import dev.emirman.util.payment.garanti.service.payment.IGPaymentService;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import static dev.emirman.util.payment.garanti.model.payment.order.base.GOrderType.SALES;

public class PayTest {

    private static GStoreConfig devConfig() {
        return GStoreConfig.builder()
                .withMode("TEST")
                .withVersion("v0.01")
                .withSecure3DLevel("3D_FULL")
                .withProvUserId("PROVAUT")
                .withProvUserPass("123qweASD/")
                .withTerminalId("30691297")
                .withMerchantId("7000679")
                .withStoreKey("12345678")
                .withCompanyName("Hexcap")
                .withSuccessUrl("http://localhost:3000")
                .withFailUrl("http://localhost:3000")
                .build();
    }

    private static InstallmentConfig installmentConfig() {
        return InstallmentConfig.builder()
                .addInstallment(Installment.builder()
                        .withValue(2)
                        .withRate(1.980)
                        .build())
                .addInstallment(Installment.builder()
                        .withValue(3)
                        .withRate(2.650)
                        .build())
                .addInstallment(Installment.builder()
                        .withValue(4)
                        .withRate(3.310)
                        .build())
                .addInstallment(Installment.builder()
                        .withValue(5)
                        .withRate(3.970)
                        .build())
                .addInstallment(Installment.builder()
                        .withValue(6)
                        .withRate(4.630)
                        .build())
                .addInstallment(Installment.builder()
                        .withValue(12)
                        .withRate(8.600)
                        .build())
                .build();
    }

    @Test
    public void pay() {
        InstallmentService installmentService = new IInstallmentService(installmentConfig());
        GPaymentService paymentService = new IGPaymentService(installmentService);
        GPayment gPayment = GPayment.builder()
                .withConfig(devConfig())
                .withOrder(GOrder.builder()
                        .withOrderId(UUID.randomUUID().toString())
                        .withInstallments(5)
                        .withAmount(100.0)
                        .withCurrency(GOrderCurrency.TRY)
                        .withLang("tr")
                        .withType(SALES)
                        .build())
                .withCustomer(GCustomer.builder()
                        .withIpAddress("1.1.1.1")
                        .withEmail("test@test.com")
                        .build())
                .withCard(GCard.builder()
                        .withCardHolderName("test")
                        .withCardNumber("4824892453725018")
                        .withCvc("567")
                        .withExpireMonth("01")
                        .withExpireYear("25")
                        .build())
                .build();
        String html = paymentService.pay(gPayment);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(html), null);
        System.out.println("HTML copied to clipboard");
        assert html != null;
    }
}
