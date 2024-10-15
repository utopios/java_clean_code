package org.example.jour2.ocp;

public class Rectangle implements Shape {
    public double width;
    public double length;

    @Override
    public double calculateArea() {
        return width * length;
    }
}
