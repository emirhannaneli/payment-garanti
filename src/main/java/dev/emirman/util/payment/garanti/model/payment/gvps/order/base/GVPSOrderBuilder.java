package dev.emirman.util.payment.garanti.model.payment.gvps.order.base;

import dev.emirman.util.payment.garanti.model.payment.gvps.order.address.GVPSOrderAddressList;

public final class GVPSOrderBuilder {
    private String orderId;
    private String groupId;
    private GVPSOrderAddressList addressList;

    GVPSOrderBuilder() {
    }

    public static GVPSOrderBuilder newBuilder() {
        return new GVPSOrderBuilder();
    }

    public GVPSOrderBuilder withOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public GVPSOrderBuilder withGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public GVPSOrderBuilder withAddressList(GVPSOrderAddressList addressList) {
        this.addressList = addressList;
        return this;
    }

    public GVPSOrder build() {
        return new GVPSOrder(orderId, groupId, addressList);
    }
}
