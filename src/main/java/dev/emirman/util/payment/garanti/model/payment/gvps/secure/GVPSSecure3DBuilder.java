package dev.emirman.util.payment.garanti.model.payment.gvps.secure;

public final class GVPSSecure3DBuilder {
    private String authenticationCode;
    private String securityLevel;
    private String txnId;
    private String md;

    GVPSSecure3DBuilder() {
    }

    public static GVPSSecure3DBuilder newBuilder() {
        return new GVPSSecure3DBuilder();
    }

    public GVPSSecure3DBuilder withAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
        return this;
    }

    public GVPSSecure3DBuilder withSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
        return this;
    }

    public GVPSSecure3DBuilder withTxnId(String txnId) {
        this.txnId = txnId;
        return this;
    }

    public GVPSSecure3DBuilder withMd(String md) {
        this.md = md;
        return this;
    }

    public GVPSSecure3D build() {
        return new GVPSSecure3D(authenticationCode, securityLevel, txnId, md);
    }
}
