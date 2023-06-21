package dev.emirman.util.payment.garanti.service.callback;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CallBackService {
    Boolean validate(String body,String storeKey) throws JsonProcessingException;
}
