package dev.emirman.util.payment.garanti.model.payment.order;

public enum GOrderCurrency {
    TRY("TRY", "949"),
    USD("USD", "840"),
    EUR("EUR", "978"),
    GBP("GBP", "826"),
    JPY("JPY", "392");

    private final String value;
    private final String code;

    GOrderCurrency(String value, String code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }
}
