package dev.emirman.util.payment.garanti.model.installment;

public class Installment {
    private int value;
    private double rate;

    public Installment() {
    }

    public Installment(int value, double rate) {
        this.value = value;
        this.rate = rate;
    }

    public static InstallmentBuilder builder() {
        return new InstallmentBuilder();
    }

    public int value() {
        return value;
    }

    public void value(int value) {
        this.value = value;
    }

    public double rate() {
        return rate;
    }

    public void rate(double rate) {
        this.rate = rate;
    }


}
