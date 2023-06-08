package dev.emirman.util.payment.garanti.model.payment.gvps.customer;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSCustomer {
    @JacksonXmlProperty(localName = "EmailAddress")
    private String email;
    @JacksonXmlProperty(localName = "IPAddress")
    private String ip;

    public GVPSCustomer() {
    }

    public GVPSCustomer(String email, String ip) {
        this.email = email;
        this.ip = ip;
    }

    public static GVPSCustomerBuilder builder() {
        return new GVPSCustomerBuilder();
    }

    public String email() {
        return email;
    }

    public GVPSCustomer withEmail(String email) {
        this.email = email;
        return this;
    }

    public String ip() {
        return ip;
    }

    public GVPSCustomer withIp(String ip) {
        this.ip = ip;
        return this;
    }
}
