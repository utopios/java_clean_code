package org.example.jour2.ocpdemo;

/*public class Shape {
    public double calculateArea(Object shape) {
        if(shape instanceof Circle) {
            return Math.PI * ((Circle) shape).radius * ((Circle) shape).radius;
        } else if(shape instanceof Rectangle) {
            return ((Rectangle) shape).length * ((Rectangle) shape).width;
        }
        return 0;
    }
}*/
interface Shape {
   default double calculateArea() {
       return 0;
   }
}