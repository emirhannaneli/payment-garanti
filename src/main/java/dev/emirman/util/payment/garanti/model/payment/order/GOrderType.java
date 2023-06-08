package dev.emirman.util.payment.garanti.model.payment.order;

public enum GOrderType {
    SALES("sales");

    private final String value;

    GOrderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
