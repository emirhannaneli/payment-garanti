package dev.emirman.util.payment.garanti.config;

public class GStoreConfig {
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

    public GStoreConfig() {
    }

    public GStoreConfig(String mode, String version, String provUserId, String provUserPass, String terminalId, String _terminalId, String merchantId, String storeKey, String secure3DLevel, String companyName, String successUrl, String failUrl) {
        this.mode = mode;
        this.version = version;
        this.provUserId = provUserId;
        this.provUserPass = provUserPass;
        this.terminalId = terminalId;
        this._terminalId = _terminalId;
        this.merchantId = merchantId;
        this.storeKey = storeKey;
        this.secure3DLevel = secure3DLevel;
        this.companyName = companyName;
        this.successUrl = successUrl;
        this.failUrl = failUrl;
    }

    public static GStoreConfigBuilder builder() {
        return new GStoreConfigBuilder();
    }

    public String mode() {
        return mode;
    }

    public GStoreConfig withMode(String mode) {
        this.mode = mode;
        return this;
    }

    public String version() {
        return version;
    }

    public GStoreConfig withVersion(String version) {
        this.version = version;
        return this;
    }

    public String provUserId() {
        return provUserId;
    }

    public GStoreConfig withProvUserId(String provUserId) {
        this.provUserId = provUserId;
        return this;
    }

    public String provUserPass() {
        return provUserPass;
    }

    public GStoreConfig withProvUserPass(String provUserPass) {
        this.provUserPass = provUserPass;
        return this;
    }

    public String terminalId() {
        return 0 + terminalId;
    }

    public GStoreConfig withTerminalId(String terminalId) {
        this.terminalId = terminalId;
        return this;
    }

    public String _terminalId() {
        return _terminalId;
    }

    public GStoreConfig with_terminalId(String _terminalId) {
        this._terminalId = _terminalId;
        return this;
    }

    public String merchantId() {
        return merchantId;
    }

    public GStoreConfig withMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public String storeKey() {
        return storeKey;
    }

    public GStoreConfig withStoreKey(String storeKey) {
        this.storeKey = storeKey;
        return this;
    }

    public String secure3DLevel() {
        return secure3DLevel;
    }

    public GStoreConfig withSecure3DLevel(String secure3DLevel) {
        this.secure3DLevel = secure3DLevel;
        return this;
    }

    public String companyName() {
        return companyName;
    }

    public GStoreConfig withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String successUrl() {
        return successUrl;
    }

    public GStoreConfig withSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
        return this;
    }

    public String failUrl() {
        return failUrl;
    }

    public GStoreConfig withFailUrl(String failUrl) {
        this.failUrl = failUrl;
        return this;
    }


}
