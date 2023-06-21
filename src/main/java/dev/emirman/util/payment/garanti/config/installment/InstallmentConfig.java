package dev.emirman.util.payment.garanti.config.installment;

import dev.emirman.util.payment.garanti.model.installment.Installment;

import java.util.List;

public class InstallmentConfig {
    private List<Installment> installments;


    public InstallmentConfig() {
    }

    public InstallmentConfig(List<Installment> installments) {
        this.installments = installments;
    }

    public static InstallmentConfigBuilder builder() {
        return new InstallmentConfigBuilder();
    }

    public List<Installment> installments() {
        return installments;
    }

    public void installments(List<Installment> installments) {
        this.installments = installments;
    }
}
