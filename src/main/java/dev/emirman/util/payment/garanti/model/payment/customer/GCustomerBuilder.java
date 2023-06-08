package dev.emirman.util.payment.garanti.model.payment.customer;

public final class GCustomerBuilder {
    private String ipAddress;
    private String email;

    GCustomerBuilder() {
    }

    public static GCustomerBuilder newBuilder() {
        return new GCustomerBuilder();
    }

    public GCustomerBuilder withIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public GCustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public GCustomer build() {
        return new GCustomer(ipAddress, email);
    }
}
