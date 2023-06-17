package dev.emirman.util.payment.garanti.model.payment.order;

import java.text.DecimalFormat;


public class GOrder {
    private String orderId;
    private String groupId;
    private Double amount;
    private GOrderType type;
    private GOrderCurrency currency;
    private Integer installments;
    private String lang;

    public GOrder() {
    }

    public GOrder(String orderId, String groupId, Double amount, GOrderType type, GOrderCurrency currency, Integer installments, String lang) {
        this.orderId = orderId;
        this.groupId = groupId;
        this.amount = amount;
        this.type = type;
        this.currency = currency;
        this.installments = installments;
        this.lang = lang;
    }

    public static GOrderBuilder builder() {
        return new GOrderBuilder();
    }

    public String orderId() {
        return orderId;
    }

    public GOrder withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String groupId() {
        return groupId;
    }

    public GOrder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GOrder withAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public GOrderType type() {
        return type;
    }

    public GOrder withType(GOrderType type) {
        this.type = type;
        return this;
    }

    public GOrderCurrency currency() {
        return currency;
    }

    public GOrder withCurrency(GOrderCurrency currency) {
        this.currency = currency;
        return this;
    }

    public GOrder withInstallments(Integer installments) {
        this.installments = installments;
        return this;
    }

    public GOrder withLang(String lang) {
        this.lang = lang;
        return this;
    }

    public String amount() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(amount).replace(".", "").replace(",", "");
    }

    public String installments() {
        return (installments == null || installments == 0) ? "" : installments.toString();
    }

    public String lang() {
        return lang == null ? "en" : lang;
    }


}
