package dev.emirman.util.payment.garanti.service.payment;

import dev.emirman.util.payment.garanti.model.payment.base.GPayment;

import java.io.IOException;

public interface GPaymentService {
    String pay(GPayment gPayment) throws IOException, InterruptedException;

}
