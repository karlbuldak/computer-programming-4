package pl.kbuldak.sales.payment;

public interface PaymentGateway {
    PaymentData register(RegisterPaymentRequest request);
}
