package org.example.peche;

public class PaymentProcessor {
    public void processPayment(String paymentType) {
        if (paymentType.equals("creditCard")) {
            // Logic for credit card payment
        } else if (paymentType.equals("paypal")) {
            // Logic for PayPal payment
        } else if (paymentType.equals("bitcoin")) {
            // Logic for Bitcoin payment
        }
    }
}
