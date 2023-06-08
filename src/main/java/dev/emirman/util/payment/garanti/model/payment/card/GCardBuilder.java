package dev.emirman.util.payment.garanti.model.payment.card;

public final class GCardBuilder {
    private String cardHolderName;
    private String cardNumber;
    private String expireMonth;
    private String expireYear;
    private String cvc;

    GCardBuilder() {
    }

    public static GCardBuilder newBuilder() {
        return new GCardBuilder();
    }

    public GCardBuilder withCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public GCardBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public GCardBuilder withExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
        return this;
    }

    public GCardBuilder withExpireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public GCardBuilder withCvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public GCard build() {
        GCard gCard = new GCard();
        gCard.withCardHolderName(cardHolderName);
        gCard.withCardNumber(cardNumber);
        gCard.withExpireMonth(expireMonth);
        gCard.withExpireYear(expireYear);
        gCard.withCvc(cvc);
        return gCard;
    }
}
