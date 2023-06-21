package dev.emirman.util.payment.garanti.model.installment;

public final class InstallmentBuilder {
    private int value;
    private double rate;

    InstallmentBuilder() {
    }

    public static InstallmentBuilder newBuilder() {
        return new InstallmentBuilder();
    }

    public InstallmentBuilder withValue(int value) {
        this.value = value;
        return this;
    }

    public InstallmentBuilder withRate(double rate) {
        this.rate = rate;
        return this;
    }

    public Installment build() {
        return new Installment(value, rate);
    }
}
