package dev.emirman.util.payment.garanti.model.payment.gvps.order.address;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSOrderAddress {
    @JacksonXmlProperty(localName = "Type")
    private String type;
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "LastName")
    private String lastName;
    @JacksonXmlProperty(localName = "Company")
    private String company;
    @JacksonXmlProperty(localName = "Text")
    private String text;
    @JacksonXmlProperty(localName = "District")
    private String district;
    @JacksonXmlProperty(localName = "City")
    private String city;
    @JacksonXmlProperty(localName = "PostalCode")
    private String postalCode;
    @JacksonXmlProperty(localName = "Country")
    private String country;
    @JacksonXmlProperty(localName = "PhoneNumber")
    private String phoneNumber;

    public GVPSOrderAddress() {
    }

    public GVPSOrderAddress(String type, String name, String lastName, String company, String text, String district, String city, String postalCode, String country, String phoneNumber) {
        this.type = type;
        this.name = name;
        this.lastName = lastName;
        this.company = company;
        this.text = text;
        this.district = district;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public static GVPSOrderAddressBuilder builder() {
        return new GVPSOrderAddressBuilder();
    }

    public String type() {
        return type;
    }

    public GVPSOrderAddress withType(String type) {
        this.type = type;
        return this;
    }

    public String name() {
        return name;
    }

    public GVPSOrderAddress withName(String name) {
        this.name = name;
        return this;
    }

    public String lastName() {
        return lastName;
    }

    public GVPSOrderAddress withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String company() {
        return company;
    }

    public GVPSOrderAddress withCompany(String company) {
        this.company = company;
        return this;
    }

    public String text() {
        return text;
    }

    public GVPSOrderAddress withText(String text) {
        this.text = text;
        return this;
    }

    public String district() {
        return district;
    }

    public GVPSOrderAddress withDistrict(String district) {
        this.district = district;
        return this;
    }

    public String city() {
        return city;
    }

    public GVPSOrderAddress withCity(String city) {
        this.city = city;
        return this;
    }

    public String postalCode() {
        return postalCode;
    }

    public GVPSOrderAddress withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String country() {
        return country;
    }

    public GVPSOrderAddress withCountry(String country) {
        this.country = country;
        return this;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public GVPSOrderAddress withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
