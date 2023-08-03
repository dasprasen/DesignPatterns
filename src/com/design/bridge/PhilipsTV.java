package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
public class PhilipsTV extends Tv {
    Remote remoteType;
    PhilipsTV(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Philips TV On: ");
        remoteType.on();
    }

    @Override
    public void off() {
        System.out.print("Philips TV Off: ");
        remoteType.off();
    }
}
