package org.example.correction.correction_adapter_1;

public class NewPaymentGateway {
    public void authenticate(String apiKey) {
        System.out.println("Authentication with key api "+apiKey);
    }

    public void sendPayment(double amount) {
        System.out.println("Payment new system "+ amount + " €");
    }
}
