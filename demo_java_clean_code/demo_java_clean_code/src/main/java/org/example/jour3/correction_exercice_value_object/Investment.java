package org.example.jour3.correction_exercice_value_object;

public class Investment {
    private final String name;
    private final int quantity;
    private final Money valuePerUnit;


    public Investment(String name, int quantity, Money valuePerUnit) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name must be valid one");
        }
        if(quantity <= 0) {
            throw new IllegalArgumentException("Qty must be postive");
        }
        this.name = name;
        this.quantity = quantity;
        this.valuePerUnit = valuePerUnit;
    }

    public Money totalValue() {
        return new Money(quantity * valuePerUnit.getAmount(), valuePerUnit.getCurrency());
    }

    @Override
    public boolean equals(Object targetObject) {
        if (targetObject == null || getClass() != targetObject.getClass()) return false;
        Investment targetInvestment = (Investment) targetObject;
        return targetInvestment.totalValue() == this.totalValue();
    }

    @Override
    public String toString() {
        return "Investment{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", valuePerUnit=" + valuePerUnit +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getValuePerUnit() {
        return valuePerUnit;
    }
}
