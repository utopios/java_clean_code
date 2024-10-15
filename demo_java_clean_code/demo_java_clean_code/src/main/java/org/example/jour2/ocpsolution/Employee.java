package org.example.jour2.ocpsolution;

public abstract class Employee implements Payable {
    private final double salary;
    //private final double bonus;

    protected Employee(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    //public abstract double payAmount();
}
