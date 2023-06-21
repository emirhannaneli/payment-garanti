package dev.emirman.util.payment.garanti.model.callback;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class CallBack {
    @JsonProperty("xid")
    private String xid;
    @JsonProperty("clientid")
    private String clientId;
    @JsonProperty("authcode")
    private String authCode;
    @JsonProperty("cavv")
    private String cavv;
    @JsonProperty("eci")
    private String eci;
    @JsonProperty("md")
    private String md;
    @JsonProperty("rnd")
    private String rnd;
    @JsonProperty("mdstatus")
    private String mdStatus;
    @JsonProperty("oid")
    private String orderId;
    @JsonProperty("response")
    private String response;
    @JsonProperty("procreturncode")
    private String returnCode;
    @JsonProperty("errmsg")
    private String errorMessage;
    @JsonProperty("hostmsg")
    private String hostMessage;
    @JsonProperty("hash")
    private String hash;
    @JsonProperty("hashparams")
    private String hashParams;
    @JsonProperty("hashparamsval")
    private String hashParamsValues;
    @JsonProperty("errorurl")
    private String errorUrl;
    @JsonProperty("successurl")
    private String successUrl;
    @JsonProperty("txnamount")
    private String amount;
    @JsonProperty("txncurrencycode")
    private String currency;
    @JsonProperty("txntype")
    private String type;

    public String xid() {
        return xid;
    }

    public String clientId() {
        return clientId;
    }

    public String authCode() {
        return authCode;
    }

    public String cavv() {
        return cavv;
    }

    public String eci() {
        return eci;
    }

    public String md() {
        return md;
    }

    public String mdStatus() {
        return mdStatus;
    }

    public String orderId() {
        return orderId;
    }

    public String response() {
        return response;
    }

    public String returnCode() {
        return returnCode;
    }

    public String errorMessage() {
        return errorMessage;
    }

    public String hostMessage() {
        return hostMessage;
    }

    public String hash() {
        return hash;
    }

    public String hashParams() {
        return hashParams;
    }

    public String hashParamsValues() {
        return hashParamsValues;
    }

    public String errorUrl() {
        return errorUrl;
    }

    public String successUrl() {
        return successUrl;
    }

    public String currency() {
        return currency;
    }

    public String type() {
        return type;
    }

    public String rnd() {
        return rnd;
    }

    public Double amount() {
        DecimalFormat df = new DecimalFormat("#0.00");
        return Double.parseDouble(df.format(Double.parseDouble(amount) / 100));
    }

}
