package dev.emirman.util.payment.garanti.model.payment.gvps.terminal;

public final class GVPSTerminalBuilder {
    private String id;
    private String provUserID;
    private String hashData;
    private String userID;
    private String merchantID;

    GVPSTerminalBuilder() {
    }

    public static GVPSTerminalBuilder newBuilder() {
        return new GVPSTerminalBuilder();
    }

    public GVPSTerminalBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public GVPSTerminalBuilder withProvUserID(String provUserID) {
        this.provUserID = provUserID;
        return this;
    }

    public GVPSTerminalBuilder withHashData(String hashData) {
        this.hashData = hashData;
        return this;
    }

    public GVPSTerminalBuilder withUserID(String userID) {
        this.userID = userID;
        return this;
    }

    public GVPSTerminalBuilder withMerchantID(String merchantID) {
        this.merchantID = merchantID;
        return this;
    }

    public GVPSTerminal build() {
        return new GVPSTerminal(id, provUserID, hashData, userID, merchantID);
    }
}
