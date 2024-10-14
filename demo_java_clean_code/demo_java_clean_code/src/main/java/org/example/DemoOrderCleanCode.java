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
        return order.getItems().stream().mapToDouble(Item::getPrice).sum();
    }

    private void printTotal(double total) {
        System.out.println("Total: " + total);
    }
}
