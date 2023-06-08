package dev.emirman.util.payment.garanti.config;

public final class GStoreConfigBuilder {
    private String mode;
    private String version;
    private String provUserId;
    private String provUserPass;
    private String terminalId;
    private String _terminalId;
    private String merchantId;
    private String storeKey;
    private String secure3DLevel;
    private String companyName;
    private String successUrl;
    private String failUrl;

    GStoreConfigBuilder() {
    }

    public static GStoreConfigBuilder newBuilder() {
        return new GStoreConfigBuilder();
    }

    public GStoreConfigBuilder withMode(String mode) {
        this.mode = mode;
        return this;
    }

    public GStoreConfigBuilder withVersion(String version) {
        this.version = version;
        return this;
    }

    public GStoreConfigBuilder withProvUserId(String provUserId) {
        this.provUserId = provUserId;
        return this;
    }

    public GStoreConfigBuilder withProvUserPass(String provUserPass) {
        this.provUserPass = provUserPass;
        return this;
    }

    public GStoreConfigBuilder withTerminalId(String terminalId) {
        this.terminalId = 0 + terminalId;
        return this;
    }

    public GStoreConfigBuilder with_terminalId(String _terminalId) {
        this._terminalId = _terminalId;
        return this;
    }

    public GStoreConfigBuilder withMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public GStoreConfigBuilder withStoreKey(String storeKey) {
        this.storeKey = storeKey;
        return this;
    }

    public GStoreConfigBuilder withSecure3DLevel(String secure3DLevel) {
        this.secure3DLevel = secure3DLevel;
        return this;
    }

    public GStoreConfigBuilder withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public GStoreConfigBuilder withSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
        return this;
    }

    public GStoreConfigBuilder withFailUrl(String failUrl) {
        this.failUrl = failUrl;
        return this;
    }

    public GStoreConfig build() {
        GStoreConfig gStoreConfig = new GStoreConfig();
        gStoreConfig.withMode(mode);
        gStoreConfig.withVersion(version);
        gStoreConfig.withProvUserId(provUserId);
        gStoreConfig.withProvUserPass(provUserPass);
        gStoreConfig.withTerminalId(terminalId);
        gStoreConfig.with_terminalId(_terminalId);
        gStoreConfig.withMerchantId(merchantId);
        gStoreConfig.withStoreKey(storeKey);
        gStoreConfig.withSecure3DLevel(secure3DLevel);
        gStoreConfig.withCompanyName(companyName);
        gStoreConfig.withSuccessUrl(successUrl);
        gStoreConfig.withFailUrl(failUrl);
        return gStoreConfig;
    }
}
