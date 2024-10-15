package org.example.jour2.ocp;

public class Circle implements Shape {
    public double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
