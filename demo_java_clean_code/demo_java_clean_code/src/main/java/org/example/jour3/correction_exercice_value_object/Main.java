package org.example.jour3.correction_exercice_value_object;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio(new ArrayList<>());
        try {
            portfolio.addInvestment(new Investment("Apple", 10, new Money(1000, "EUR")));
            portfolio.addInvestment(new Investment("Tesla", 10, new Money(400, "EUR")));
        }catch (Exception ex) {

        }
    }
}
