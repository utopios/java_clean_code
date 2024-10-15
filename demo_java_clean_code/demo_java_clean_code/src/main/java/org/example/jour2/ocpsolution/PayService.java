package org.example.jour2.ocpsolution;

public class PayService implements Payable {
    @Override
    public double payAmount(Engineer employee) {
        return employee.getSalary();
    }
    @Override
    public double payAmount(Manager employee) {
        return employee.getSalary() + employee.getBonus();
    }

    /*@Override
    public double payAmount(Employee employee) {
        if(employee instanceof Manager) {
            return ((Manager) employee).getBonus() + ((Manager) employee).getSalary();
        } else if(employee instanceof Engineer) {
            return  ((Engineer) employee).getSalary();
        }
        return 0;
    }*/
}
