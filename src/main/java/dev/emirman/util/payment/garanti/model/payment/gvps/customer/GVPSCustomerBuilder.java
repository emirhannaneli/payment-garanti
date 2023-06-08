package dev.emirman.util.payment.garanti.model.payment.gvps.customer;

public final class GVPSCustomerBuilder {
    private String email;
    private String ip;

    GVPSCustomerBuilder() {
    }

    public static GVPSCustomerBuilder newBuilder() {
        return new GVPSCustomerBuilder();
    }

    public GVPSCustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public GVPSCustomerBuilder withIp(String ip) {
        this.ip = ip;
        return this;
    }

    public GVPSCustomer build() {
        return new GVPSCustomer(email, ip);
    }
}
