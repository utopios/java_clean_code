package org.example.demo_revision_singelton;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println(QuiCorrige.getInstance().quiCorrige());
            Thread.sleep(1000);
        }
    }
}
