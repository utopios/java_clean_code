package org.example.jour3.correction_exercice_value_object;

public class PortfolioDisplayer {

    private final Portfolio portfolio;

    public PortfolioDisplayer(Portfolio portfolio) {
        this.portfolio = portfolio;
    }


    public void display() {
        this.portfolio.getInvestments().forEach(investment -> {
            System.out.println(investment);
        });
    }
}
