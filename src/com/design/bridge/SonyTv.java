package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
public class SonyTv extends Tv {
    Remote remoteType;
    SonyTv(Remote r) {
        super(r);
        this.remoteType = r;
    }

    @Override
    public void on() {
        System.out.print("Sony TV On: ");
        remoteType.on();
    }

    @Override
    public void off() {
        System.out.print("Sony TV Off: ");
        remoteType.off();
    }
}
