package dev.emirman.util.payment.garanti.model.payment.gvps.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import dev.emirman.util.payment.garanti.model.payment.gvps.order.base.GVPSOrder;
import dev.emirman.util.payment.garanti.model.payment.gvps.terminal.GVPSTerminal;
import dev.emirman.util.payment.garanti.model.payment.gvps.transaction.GVPSTransaction;
import dev.emirman.util.payment.garanti.model.payment.gvps.card.GVPSCard;
import dev.emirman.util.payment.garanti.model.payment.gvps.customer.GVPSCustomer;


@JacksonXmlRootElement(localName = "GVPSRequest")
public class GVPSRequest {
    @JacksonXmlProperty(localName = "Mode")
    private String mode;
    @JacksonXmlProperty(localName = "Version")
    private String version;
    @JacksonXmlProperty(localName = "ChannelCode")
    private String channelCode;
    @JacksonXmlProperty(localName = "Terminal")
    private GVPSTerminal terminal;
    @JacksonXmlProperty(localName = "Customer")
    private GVPSCustomer customer;
    @JacksonXmlProperty(localName = "Card")
    private GVPSCard card;
    @JacksonXmlProperty(localName = "Order")
    private GVPSOrder order;
    @JacksonXmlProperty(localName = "Transaction")
    private GVPSTransaction transaction;

    public GVPSRequest() {
    }

    public GVPSRequest(String mode, String version, String channelCode, GVPSTerminal terminal, GVPSCustomer customer, GVPSCard card, GVPSOrder order, GVPSTransaction transaction) {
        this.mode = mode;
        this.version = version;
        this.channelCode = channelCode;
        this.terminal = terminal;
        this.customer = customer;
        this.card = card;
        this.order = order;
        this.transaction = transaction;
    }

    public static GVPSRequestBuilder newBuilder() {
        return new GVPSRequestBuilder();
    }

    public String mode() {
        return mode;
    }

    public GVPSRequest withMode(String mode) {
        this.mode = mode;
        return this;
    }

    public String version() {
        return version;
    }

    public GVPSRequest withVersion(String version) {
        this.version = version;
        return this;
    }

    public String channelCode() {
        return channelCode;
    }

    public GVPSRequest withChannelCode(String channelCode) {
        this.channelCode = channelCode;
        return this;
    }

    public GVPSTerminal terminal() {
        return terminal;
    }

    public GVPSRequest withTerminal(GVPSTerminal terminal) {
        this.terminal = terminal;
        return this;
    }

    public GVPSCustomer customer() {
        return customer;
    }

    public GVPSRequest withCustomer(GVPSCustomer customer) {
        this.customer = customer;
        return this;
    }

    public GVPSCard card() {
        return card;
    }

    public GVPSRequest withCard(GVPSCard card) {
        this.card = card;
        return this;
    }

    public GVPSOrder order() {
        return order;
    }

    public GVPSRequest withOrder(GVPSOrder order) {
        this.order = order;
        return this;
    }

    public GVPSTransaction transaction() {
        return transaction;
    }

    public GVPSRequest withTransaction(GVPSTransaction transaction) {
        this.transaction = transaction;
        return this;
    }
}
