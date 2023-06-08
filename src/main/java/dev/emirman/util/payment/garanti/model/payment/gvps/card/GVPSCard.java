package dev.emirman.util.payment.garanti.model.payment.gvps.card;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSCard {
    @JacksonXmlProperty(localName = "Number")
    private String number;
    @JacksonXmlProperty(localName = "ExpireDate")
    private String expireDate;
    @JacksonXmlProperty(localName = "CVV2")
    private String cvv2;

    public GVPSCard() {
    }

    public GVPSCard(String number, String expireDate, String cvv2) {
        this.number = number;
        this.expireDate = expireDate;
        this.cvv2 = cvv2;
    }

    public static GVPSCardBuilder builder() {
        return new GVPSCardBuilder();
    }

    public String number() {
        return number;
    }

    public GVPSCard withNumber(String number) {
        this.number = number;
        return this;
    }

    public String expireDate() {
        return expireDate;
    }

    public GVPSCard withExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public String cvv2() {
        return cvv2;
    }

    public GVPSCard withCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }
}
