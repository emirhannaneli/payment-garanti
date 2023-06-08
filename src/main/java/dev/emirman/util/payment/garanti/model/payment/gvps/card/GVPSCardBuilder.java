package dev.emirman.util.payment.garanti.model.payment.gvps.card;

public final class GVPSCardBuilder {
    private String number;
    private String expireDate;
    private String cvv2;

    GVPSCardBuilder() {
    }

    public static GVPSCardBuilder newBuilder() {
        return new GVPSCardBuilder();
    }

    public GVPSCardBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public GVPSCardBuilder withExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public GVPSCardBuilder withCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public GVPSCard build() {
        return new GVPSCard(number, expireDate, cvv2);
    }
}
