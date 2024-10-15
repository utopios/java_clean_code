package org.example.jour2.demoidp;

public class Switch {
    private final Switchable device;

    public Switch(Switchable switchable) {
        this.device = switchable;
    }

    public void operate() {
        this.device.switchOn();
    }
}
