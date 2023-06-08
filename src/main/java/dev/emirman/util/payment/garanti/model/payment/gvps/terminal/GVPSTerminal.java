package dev.emirman.util.payment.garanti.model.payment.gvps.terminal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSTerminal {
    @JacksonXmlProperty(localName = "ID")
    public String id;
    @JacksonXmlProperty(localName = "ProvUserID")
    public String provUserID;
    @JacksonXmlProperty(localName = "HashData")
    public String hashData;
    @JacksonXmlProperty(localName = "UserID")
    public String userID;
    @JacksonXmlProperty(localName = "MerchantID")
    public String merchantID;

    public GVPSTerminal() {
    }

    public GVPSTerminal(String id, String provUserID, String hashData, String userID, String merchantID) {
        this.id = id;
        this.provUserID = provUserID;
        this.hashData = hashData;
        this.userID = userID;
        this.merchantID = merchantID;
    }

    public static GVPSTerminalBuilder newBuilder() {
        return new GVPSTerminalBuilder();
    }

    public String id() {
        return id;
    }

    public GVPSTerminal withId(String id) {
        this.id = id;
        return this;
    }

    public String provUserID() {
        return provUserID;
    }

    public GVPSTerminal withProvUserID(String provUserID) {
        this.provUserID = provUserID;
        return this;
    }

    public String hashData() {
        return hashData;
    }

    public GVPSTerminal withHashData(String hashData) {
        this.hashData = hashData;
        return this;
    }

    public String userID() {
        return userID;
    }

    public GVPSTerminal withUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public String merchantID() {
        return merchantID;
    }

    public GVPSTerminal withMerchantID(String merchantID) {
        this.merchantID = merchantID;
        return this;
    }
}
