package dev.emirman.util.payment.garanti.service.payment;

import dev.emirman.util.payment.garanti.model.payment.base.GPayment;

import java.io.IOException;

public interface GPaymentService {
    String createRequest(GPayment gPayment) throws IOException, InterruptedException;

}
