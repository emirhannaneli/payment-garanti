package dev.emirman.util.payment.garanti.model.payment.order.base;

public final class GOrderBuilder {
    private String orderId;
    private String groupId;
    private Double amount;
    private GOrderType type;
    private GOrderCurrency currency;
    private Integer installments;
    private String lang;

    GOrderBuilder() {
    }

    public static GOrderBuilder newBuilder() {
        return new GOrderBuilder();
    }

    public GOrderBuilder withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public GOrderBuilder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GOrderBuilder withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public GOrderBuilder withType(GOrderType type) {
        this.type = type;
        return this;
    }

    public GOrderBuilder withCurrency(GOrderCurrency currency) {
        this.currency = currency;
        return this;
    }

    public GOrderBuilder withInstallments(Integer installments) {
        this.installments = installments;
        return this;
    }

    public GOrderBuilder withLang(String lang) {
        this.lang = lang;
        return this;
    }

    public GOrder build() {
        return new GOrder(orderId, groupId, amount, type, currency, installments, lang);
    }
}
