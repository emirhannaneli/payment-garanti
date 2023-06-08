package dev.emirman.util.payment.garanti.model.payment.gvps.transaction;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import dev.emirman.util.payment.garanti.model.payment.gvps.secure.GVPSSecure3D;


public class GVPSTransaction {
    @JacksonXmlProperty(localName = "Type")
    private String type;
    @JacksonXmlProperty(localName = "InstallmentCnt")
    private String installmentCnt;
    @JacksonXmlProperty(localName = "Amount")
    private String amount;
    @JacksonXmlProperty(localName = "CurrencyCode")
    private String currencyCode;
    @JacksonXmlProperty(localName = "CardholderPresentCode")
    private String cardholderPresentCode;
    @JacksonXmlProperty(localName = "MotoInd")
    private String motoInd;
    @JacksonXmlProperty(localName = "Secure3D")
    private GVPSSecure3D secure3D;

    public GVPSTransaction() {
    }

    public GVPSTransaction(String type, String installmentCnt, String amount, String currencyCode, String cardholderPresentCode, String motoInd, GVPSSecure3D secure3D) {
        this.type = type;
        this.installmentCnt = installmentCnt;
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.cardholderPresentCode = cardholderPresentCode;
        this.motoInd = motoInd;
        this.secure3D = secure3D;
    }

    public static GVPSTransactionBuilder newBuilder() {
        return new GVPSTransactionBuilder();
    }

    public String type() {
        return type;
    }

    public GVPSTransaction withType(String type) {
        this.type = type;
        return this;
    }

    public String installmentCnt() {
        return installmentCnt;
    }

    public GVPSTransaction withInstallmentCnt(String installmentCnt) {
        this.installmentCnt = installmentCnt;
        return this;
    }

    public String amount() {
        return amount;
    }

    public GVPSTransaction withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public String currencyCode() {
        return currencyCode;
    }

    public GVPSTransaction withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public String cardholderPresentCode() {
        return cardholderPresentCode;
    }

    public GVPSTransaction withCardholderPresentCode(String cardholderPresentCode) {
        this.cardholderPresentCode = cardholderPresentCode;
        return this;
    }

    public String motoInd() {
        return motoInd;
    }

    public GVPSTransaction withMotoInd(String motoInd) {
        this.motoInd = motoInd;
        return this;
    }

    public GVPSSecure3D secure3D() {
        return secure3D;
    }

    public GVPSTransaction withSecure3D(GVPSSecure3D secure3D) {
        this.secure3D = secure3D;
        return this;
    }
}
