package dev.emirman.util.payment.garanti.model.payment.base;

import dev.emirman.util.payment.garanti.config.GStoreConfig;
import dev.emirman.util.payment.garanti.model.payment.card.GCard;
import dev.emirman.util.payment.garanti.model.payment.customer.GCustomer;
import dev.emirman.util.payment.garanti.model.payment.order.GOrder;


public class GPayment {
    private GStoreConfig config;
    private GOrder order;
    private GCustomer customer;
    private GCard card;

    public GPayment() {
    }

    public GPayment(GStoreConfig config, GOrder order, GCustomer customer, GCard card) {
        this.config = config;
        this.order = order;
        this.customer = customer;
        this.card = card;
    }

    public static GPaymentBuilder builder() {
        return new GPaymentBuilder();
    }

    public GStoreConfig config() {
        return config;
    }

    public GPayment withConfig(GStoreConfig config) {
        this.config = config;
        return this;
    }

    public GOrder order() {
        return order;
    }

    public GPayment withOrder(GOrder order) {
        this.order = order;
        return this;
    }

    public GCustomer customer() {
        return customer;
    }

    public GPayment withCustomer(GCustomer customer) {
        this.customer = customer;
        return this;
    }

    public GCard card() {
        return card;
    }

    public GPayment withCard(GCard card) {
        this.card = card;
        return this;
    }
}
