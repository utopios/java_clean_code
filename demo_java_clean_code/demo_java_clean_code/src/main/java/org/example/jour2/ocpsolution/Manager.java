package org.example.jour2.ocpsolution;

public class Manager extends Employee {

    private final double bonus;

    protected Manager(double salary, double bonus) {
        super(salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    /*@Override
    public double payAmount() {
        return getSalary() + getBonus();
    }*/
}
