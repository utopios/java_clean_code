package org.example.jour4.codesmell;
import java.util.List;
public class Report {
    public void generateReport(List<Transaction> transactions) {
        double total = 0;
        for (Transaction t : transactions) {
            // Calcul du total
            total += t.getAmount();
            // Affichage des détails de la transaction
            System.out.println("Transaction ID: " + t.getId());
            System.out.println("Amount: " + t.getAmount());
            System.out.println("Date: " + t.getDate());
            // Vérification de fraudes potentielles
            if (t.isSuspicious()) {
                alertFraud(t);
            }
        }
        // Affichage du total
        System.out.println("Total Amount: " + total);
    }

    private void alertFraud(Transaction t) {
    }
}
