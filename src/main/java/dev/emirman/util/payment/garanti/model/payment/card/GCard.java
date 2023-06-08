package dev.emirman.util.payment.garanti.model.payment.card;


public class GCard {
    private String cardHolderName;
    private String cardNumber;
    private String expireMonth;
    private String expireYear;
    private String cvc;

    public GCard() {
    }


    public GCard(String cardHolderName, String cardNumber, String expireMonth, String expireYear, String cvc) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expireMonth = expireMonth;
        this.expireYear = expireYear;
        this.cvc = cvc;
    }

    public static GCardBuilder builder() {
        return new GCardBuilder();
    }

    public String cardHolderName() {
        return cardHolderName;
    }

    public GCard withCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }

    public String cardNumber() {
        return cardNumber;
    }

    public GCard withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String expireMonth() {
        return expireMonth;
    }

    public GCard withExpireMonth(String expireMonth) {
        this.expireMonth = expireMonth;
        return this;
    }

    public String expireYear() {
        return expireYear;
    }

    public GCard withExpireYear(String expireYear) {
        this.expireYear = expireYear;
        return this;
    }

    public String cvc() {
        return cvc;
    }

    public GCard withCvc(String cvc) {
        this.cvc = cvc;
        return this;
    }


}
