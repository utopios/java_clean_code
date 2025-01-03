package org.example;



public class DemoOrderCleanCode {

    // Mauvais code : la méthode fait trop de choses
    /*public void handleOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Empty order");
        }
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }
        System.out.println("Total: " + total);
    }*/

    // Clean Code : méthode décomposée en petites parties
    public void handleOrder(Order order) {
        validateOrder(order);
        double total = calculateTotal(order);
        printTotal(total);
    }

    private void validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Empty order");
        }
    }

    private double calculateTotal(Order order) {
        //return order.getItems().stream().mapToDouble(Item::getPrice).sum();
        return 0;
    }

    private void printTotal(double total) {
        System.out.println("Total: " + total);
    }


    public void calculateDiscountForOrder(Order order) {
        double discount = 0;
        if (order.getTotal() > 100) {
            discount = order.getTotal() * 0.10;
        }
        // Code de calcul des taxes
        double tax = order.getTotal() * 0.20;
        System.out.println("Discount: " + discount + ", Tax: " + tax);
    }

    public void calculateDiscountForAnotherOrder(Order order) {
        double discount = 0;
        if (order.getTotal() > 300) {
            discount = order.getTotal() * 0.15;
        }
        // Code de calcul des taxes
        double tax = order.getTotal() * 0.20;
        System.out.println("Discount: " + discount + ", Tax: " + tax);
    }

    public void printOrderDetails(Order order) {
        double discount  = calculateDiscount(order);
        double tax = calculateTax(order);
        System.out.println("Discount: " + discount + ", Tax: " + tax);
    }

    private double calculateDiscount(Order order) {
        double discount = 0;
        if (order.getTotal() > 300) {
            discount = order.getTotal() * 0.15;
        }
        return discount;
    }

    private double calculateTax(Order order) {
        // Code de calcul des taxes
        double tax = order.getTotal() * 0.20;
        return tax;
    }


    public void processOrder(Order order) {
        // Validation de la commande
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order is empty");
        }

        // Calcul du prix total
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getPrice();
        }

        // Impression des détails
        System.out.println("Total: " + total);

        // Expédition
        System.out.println("Shipping to: " + order.getAddress());
    }
}

