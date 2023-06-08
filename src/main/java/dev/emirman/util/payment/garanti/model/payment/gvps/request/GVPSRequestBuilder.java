package dev.emirman.util.payment.garanti.model.payment.gvps.request;

import dev.emirman.util.payment.garanti.model.payment.gvps.card.GVPSCard;
import dev.emirman.util.payment.garanti.model.payment.gvps.customer.GVPSCustomer;
import dev.emirman.util.payment.garanti.model.payment.gvps.order.base.GVPSOrder;
import dev.emirman.util.payment.garanti.model.payment.gvps.terminal.GVPSTerminal;
import dev.emirman.util.payment.garanti.model.payment.gvps.transaction.GVPSTransaction;

public final class GVPSRequestBuilder {
    private String mode;
    private String version;
    private String channelCode;
    private GVPSTerminal terminal;
    private GVPSCustomer customer;
    private GVPSCard card;
    private GVPSOrder order;
    private GVPSTransaction transaction;

    GVPSRequestBuilder() {
    }

    public static GVPSRequestBuilder newBuilder() {
        return new GVPSRequestBuilder();
    }

    public GVPSRequestBuilder withMode(String mode) {
        this.mode = mode;
        return this;
    }

    public GVPSRequestBuilder withVersion(String version) {
        this.version = version;
        return this;
    }

    public GVPSRequestBuilder withChannelCode(String channelCode) {
        this.channelCode = channelCode;
        return this;
    }

    public GVPSRequestBuilder withTerminal(GVPSTerminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public GVPSRequestBuilder withCustomer(GVPSCustomer customer) {
        this.customer = customer;
        return this;
    }

    public GVPSRequestBuilder withCard(GVPSCard card) {
        this.card = card;
        return this;
    }

    public GVPSRequestBuilder withOrder(GVPSOrder order) {
        this.order = order;
        return this;
    }

    public GVPSRequestBuilder withTransaction(GVPSTransaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public GVPSRequest build() {
        return new GVPSRequest(mode, version, channelCode, terminal, customer, card, order, transaction);
    }
}
