package dev.emirman.util.payment.garanti.config.installment;

import dev.emirman.util.payment.garanti.model.installment.Installment;

import java.util.ArrayList;
import java.util.List;

public final class InstallmentConfigBuilder {
    private List<Installment> installments;

    InstallmentConfigBuilder() {
        installments = new ArrayList<>();
    }

    public static InstallmentConfigBuilder newBuilder() {
        return new InstallmentConfigBuilder();
    }

    public InstallmentConfigBuilder withInstallments(List<Installment> installments) {
        this.installments = installments;
        return this;
    }

    public InstallmentConfigBuilder addInstallment(Installment installment) {
        this.installments.add(installment);
        return this;
    }

    public InstallmentConfig build() {
        return new InstallmentConfig(installments);
    }
}
