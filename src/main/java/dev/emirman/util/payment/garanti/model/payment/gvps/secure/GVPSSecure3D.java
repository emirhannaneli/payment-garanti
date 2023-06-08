package dev.emirman.util.payment.garanti.model.payment.gvps.secure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class GVPSSecure3D {
    @JacksonXmlProperty(localName = "AuthenticationCode")
    private String authenticationCode;
    @JacksonXmlProperty(localName = "SecurityLevel")
    private String securityLevel;
    @JacksonXmlProperty(localName = "TxnID")
    private String txnId;
    @JacksonXmlProperty(localName = "Md")
    private String md;

    public GVPSSecure3D() {
    }

    public GVPSSecure3D(String authenticationCode, String securityLevel, String txnId, String md) {
        this.authenticationCode = authenticationCode;
        this.securityLevel = securityLevel;
        this.txnId = txnId;
        this.md = md;
    }

    public static GVPSSecure3DBuilder newBuilder() {
        return new GVPSSecure3DBuilder();
    }

    public String authenticationCode() {
        return authenticationCode;
    }

    public GVPSSecure3D withAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
        return this;
    }

    public String securityLevel() {
        return securityLevel;
    }

    public GVPSSecure3D withSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
        return this;
    }

    public String txnId() {
        return txnId;
    }

    public GVPSSecure3D withTxnId(String txnId) {
        this.txnId = txnId;
        return this;
    }

    public String md() {
        return md;
    }

    public GVPSSecure3D withMd(String md) {
        this.md = md;
        return this;
    }
}
