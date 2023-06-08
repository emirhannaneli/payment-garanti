package dev.emirman.util.payment.garanti.model.payment.customer;

public class GCustomer {
    private String ipAddress;
    private String email;

    public GCustomer() {
    }

    public GCustomer(String ipAddress, String email) {
        this.ipAddress = ipAddress;
        this.email = email;
    }

    public static GCustomerBuilder builder() {
        return new GCustomerBuilder();
    }

    public String ipAddress() {
        return ipAddress;
    }

    public GCustomer withIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String email() {
        return email;
    }

    public GCustomer withEmail(String email) {
        this.email = email;
        return this;
    }
}
