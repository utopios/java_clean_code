package org.example.jour2.ocpdemo;

public class Circle implements Shape {
    public double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
