package dev.emirman.util.payment.garanti.model.payment.base;

import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.config.GStoreConfig;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import dev.emirman.util.payment.garanti.model.payment.order.GOrder;

public final class GPaymentBuilder {
    private GStoreConfig config;
    private GOrder order;
    private GCustomer customer;
    private GCard card;

    GPaymentBuilder() {
    }

    public static GPaymentBuilder newBuilder() {
        return new GPaymentBuilder();
    }

    public GPaymentBuilder withConfig(GStoreConfig config) {
        this.config = config;
        return this;
    }

    public GPaymentBuilder withOrder(GOrder order) {
        this.order = order;
        return this;
    }

    public GPaymentBuilder withCustomer(GCustomer customer) {
        this.customer = customer;
        return this;
    }

    public GPaymentBuilder withCard(GCard card) {
        this.card = card;
        return this;
    }

    public GPayment build() {
        return new GPayment(config, order, customer, card);
    }
}
