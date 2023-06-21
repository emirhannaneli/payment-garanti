import dev.emirman.util.payment.garanti.config.installment.InstallmentConfig;
import dev.emirman.util.payment.garanti.model.installment.Installment;
import dev.emirman.util.payment.garanti.service.installment.IInstallmentService;
import dev.emirman.util.payment.garanti.service.installment.InstallmentService;
import org.junit.jupiter.api.Test;

public class CheckInstallmentTest {
    private static InstallmentConfig devConfig() {
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
    public void check() {
        InstallmentService service = new IInstallmentService(devConfig());
        assert service.calculate(1000,12) == 1086.00;
    }
}
