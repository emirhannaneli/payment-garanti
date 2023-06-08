package dev.emirman.util.payment.garanti.model.payment.gvps.order.address;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSOrderAddressList {
    @JacksonXmlProperty(localName = "Address")
    private GVPSOrderAddress address;

    public GVPSOrderAddressList() {
    }

    public GVPSOrderAddressList(GVPSOrderAddress address) {
        this.address = address;
    }

    public static GVPSOrderAddressListBuilder builder() {
        return new GVPSOrderAddressListBuilder();
    }

    public GVPSOrderAddress address() {
        return address;
    }

    public GVPSOrderAddressList withAddress(GVPSOrderAddress address) {
        this.address = address;
        return this;
    }
}
