package com.design.lld_Design_1;

public class AlexaDeviceFactory {
    public static AlexaDevice createEchoDot(boolean isBatteryPowered) {
        EchoDot echoDot = new EchoDot();
        if (isBatteryPowered) {
            echoDot.setPowerSource(new BatteryPower(80));
        } else {
            echoDot.setPowerSource(new PlugInPower(true));
        }
        return echoDot;
    }

    public static AlexaDevice createEchoDotHybrid() {
        EchoDot echoDot = new EchoDot();
        BatteryPower battery = new BatteryPower(75);
        PlugInPower plugIn = new PlugInPower(true);
        echoDot.setPowerSource(new HybridPower(battery, plugIn));
        return echoDot;
    }

    public static AlexaDevice createEchoShow() {
        EchoShow echoShow = new EchoShow();
        echoShow.setPowerSource(new PlugInPower(true));
        return echoShow;
    }

    public static AlexaDevice createAmazonEcho() {
        AmazonEcho amazonEcho = new AmazonEcho();
        amazonEcho.setPowerSource(new PlugInPower(true));
        return amazonEcho;
    }

}
