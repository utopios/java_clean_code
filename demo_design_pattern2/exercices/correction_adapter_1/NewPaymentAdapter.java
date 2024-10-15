package org.example.correction.correction_adapter_1;

public class NewPaymentAdapter implements OldPaymentGateway {

    private NewPaymentGateway newPaymentGateway;

    public NewPaymentAdapter() {
        newPaymentGateway = new NewPaymentGateway();
    }

    @Override
    public void makePayment(String accountNumber, double amount) {
        //Authentication
        newPaymentGateway.authenticate(accountNumber);
        newPaymentGateway.sendPayment(1000);
    }
}
