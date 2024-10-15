package com.example.service;

import com.example.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.time.MonthDay;


@Named("type1")
@ApplicationScoped
public class BirthdayGreeterImpl implements BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;

    public BirthdayGreeterImpl(EmployeeRepository employeeRepository, Clock clock) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> new EmailSenderImpl().send(email));
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }

}