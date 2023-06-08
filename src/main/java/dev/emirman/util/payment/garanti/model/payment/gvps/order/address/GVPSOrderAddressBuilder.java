package dev.emirman.util.payment.garanti.model.payment.gvps.order.address;

public final class GVPSOrderAddressBuilder {
    private String type;
    private String name;
    private String lastName;
    private String company;
    private String text;
    private String district;
    private String city;
    private String postalCode;
    private String country;
    private String phoneNumber;

    GVPSOrderAddressBuilder() {
    }

    public static GVPSOrderAddressBuilder newBuilder() {
        return new GVPSOrderAddressBuilder();
    }

    public GVPSOrderAddressBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public GVPSOrderAddressBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public GVPSOrderAddressBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GVPSOrderAddressBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public GVPSOrderAddressBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public GVPSOrderAddressBuilder withDistrict(String district) {
        this.district = district;
        return this;
    }

    public GVPSOrderAddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public GVPSOrderAddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public GVPSOrderAddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public GVPSOrderAddressBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public GVPSOrderAddress build() {
        return new GVPSOrderAddress(type, name, lastName, company, text, district, city, postalCode, country, phoneNumber);
    }
}
