package dev.emirman.util.payment.garanti.model.payment.gvps.transaction;

import dev.emirman.util.payment.garanti.model.payment.gvps.secure.GVPSSecure3D;

public final class GVPSTransactionBuilder {
    private String type;
    private String installmentCnt;
    private String amount;
    private String currencyCode;
    private String cardholderPresentCode;
    private String motoInd;
    private GVPSSecure3D secure3D;

    GVPSTransactionBuilder() {
    }

    public static GVPSTransactionBuilder newBuilder() {
        return new GVPSTransactionBuilder();
    }

    public GVPSTransactionBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public GVPSTransactionBuilder withInstallmentCnt(String installmentCnt) {
        this.installmentCnt = installmentCnt;
        return this;
    }

    public GVPSTransactionBuilder withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public GVPSTransactionBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GVPSTransactionBuilder withCardholderPresentCode(String cardholderPresentCode) {
        this.cardholderPresentCode = cardholderPresentCode;
        return this;
    }

    public GVPSTransactionBuilder withMotoInd(String motoInd) {
        this.motoInd = motoInd;
        return this;
    }

    public GVPSTransactionBuilder withSecure3D(GVPSSecure3D secure3D) {
        this.secure3D = secure3D;
        return this;
    }

    public GVPSTransaction build() {
        return new GVPSTransaction(type, installmentCnt, amount, currencyCode, cardholderPresentCode, motoInd, secure3D);
    }
}
