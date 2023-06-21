package dev.emirman.util.payment.garanti.model.payment.order.base;

public enum GOrderType {
    SALES("sales"),
    EXTENDED_CREDIT_INQ("extendedcreditinq");
    private final String value;

    GOrderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
