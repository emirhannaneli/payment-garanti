package dev.emirman.util.payment.garanti.service.callback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.emirman.util.payment.garanti.model.callback.CallBack;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public record ICallBackService() implements CallBackService {
    @Override
    public Boolean validate(String body, String storeKey) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        CallBack callBack = mapper.readValue(body, CallBack.class);

        boolean isValidCallBack = callBack.returnCode().equals("00");

        if (!isValidCallBack) return false;

        String hash = callBack.hash();

        String params = callBack.clientId() +
                callBack.orderId() +
                callBack.authCode() +
                callBack.returnCode() +
                callBack.response() +
                callBack.mdStatus() +
                callBack.cavv() +
                callBack.eci() +
                callBack.md() +
                callBack.rnd() +
                storeKey;

        byte[] paramsBytes = params.getBytes(StandardCharsets.UTF_8);
        byte[] paramsHash = sha1(paramsBytes);
        String calculatedHash = Base64.getEncoder().encodeToString(paramsHash);

        return hash.equals(calculatedHash);
    }

    private byte[] sha1(byte[] data) {
        return DigestUtils.sha1(data);
    }
}
