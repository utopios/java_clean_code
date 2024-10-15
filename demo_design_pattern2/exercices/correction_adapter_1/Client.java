package org.example.correction.correction_adapter_1;

public class Client {

    public static void main(String[] args) {
        /*OldPaymentGateway paymentGateway = new OldPaymentGateway() {
            @Override
            public void makePayment(String accountNumber, double amount) {
                System.out.println("Old payment");
            }
        };*/
        OldPaymentGateway paymentGateway = new NewPaymentAdapter();

        //Avec la même syntaxe
        paymentGateway.makePayment("132243", 100);
    }
}
