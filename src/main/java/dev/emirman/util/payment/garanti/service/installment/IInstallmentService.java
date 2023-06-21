package dev.emirman.util.payment.garanti.service.installment;

import dev.emirman.util.payment.garanti.config.installment.InstallmentConfig;

public record IInstallmentService(InstallmentConfig config) implements InstallmentService {
    @Override
    public double calculate(double amount, int installment) {
        double rate = config.installments().stream()
                .filter(inst -> inst.value() == installment)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Installment not found"))
                .rate();
        return amount + (amount / 100 * rate);
    }
}
