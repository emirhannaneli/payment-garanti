package dev.emirman.util.payment.garanti.model.payment.gvps.order.address;

public final class GVPSOrderAddressListBuilder {
    private GVPSOrderAddress address;

    GVPSOrderAddressListBuilder() {
    }

    public static GVPSOrderAddressListBuilder newBuilder() {
        return new GVPSOrderAddressListBuilder();
    }

    public GVPSOrderAddressListBuilder withAddress(GVPSOrderAddress address) {
        this.address = address;
        return this;
    }

    public GVPSOrderAddressList build() {
        return new GVPSOrderAddressList(address);
    }
}
