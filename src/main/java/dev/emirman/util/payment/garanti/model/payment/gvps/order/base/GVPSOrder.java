package dev.emirman.util.payment.garanti.model.payment.gvps.order.base;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import dev.emirman.util.payment.garanti.model.payment.gvps.order.address.GVPSOrderAddressList;


public class GVPSOrder {
    @JacksonXmlProperty(localName = "OrderID")
    private String orderId;
    @JacksonXmlProperty(localName = "GroupID")
    private String groupId;
    @JacksonXmlProperty(localName = "AddressList")
    private GVPSOrderAddressList addressList;

    public GVPSOrder() {
    }

    public GVPSOrder(String orderId, String groupId, GVPSOrderAddressList addressList) {
        this.orderId = orderId;
        this.groupId = groupId;
        this.addressList = addressList;
    }

    public static GVPSOrderBuilder builder() {
        return new GVPSOrderBuilder();
    }

    public String orderId() {
        return orderId;
    }

    public GVPSOrder withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String groupId() {
        return groupId;
    }

    public GVPSOrder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GVPSOrderAddressList addressList() {
        return addressList;
    }

    public GVPSOrder withAddressList(GVPSOrderAddressList addressList) {
        this.addressList = addressList;
        return this;
    }
}
