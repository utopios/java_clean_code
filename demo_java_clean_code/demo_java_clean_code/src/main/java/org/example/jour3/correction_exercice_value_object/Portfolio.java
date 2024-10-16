package org.example.jour3.correction_exercice_value_object;

import java.util.Collections;
import java.util.List;

public class Portfolio {
    private final List<Investment> investments;


    public Portfolio(List<Investment> investments) {
        this.investments = investments;
    }

    public void addInvestment(Investment investment) {
        if(investment == null) {
            throw new IllegalArgumentException("Investment cannot be null");
        }
        this.investments.add(investment);
    }

    public Money totalProtfolioValue() {
        return investments.stream()
                .map(Investment::totalValue)
                .reduce(new Money(0, "EUR"), Money::add);
    }


    public List<Investment> getInvestments() {
        return Collections.unmodifiableList(investments);
    }

}
