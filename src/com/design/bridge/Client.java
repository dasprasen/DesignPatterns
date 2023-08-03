package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
public class Client {
    public static void main(String[] args) {
        Tv sonyOldRemote = new SonyTv(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        Tv sonyNewRemote = new SonyTv(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        Tv philipsOldRemote = new PhilipsTV(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        Tv philipsNewRemote = new PhilipsTV(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
        System.out.println();
    }
}
