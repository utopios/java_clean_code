package org.example.peche;


public class Invoice {
    public double calculateTotal(double amount, double taxRate) {
        double tax = amount * taxRate;
        return amount + tax;
    }
}
