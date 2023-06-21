package dev.emirman.util.payment.garanti.exception;

public class PaymentRequestSentFailed extends RuntimeException {
    public PaymentRequestSentFailed(Exception e) {
        super("Payment request could not be sent.", e);
    }
}
