package com.design.lld_Design_1;

public class AlexaDemo {
    public static void main(String[] args) {
        AlexaDevice echoDot = AlexaDeviceFactory.createEchoDot(true);
        AlexaDevice echoDotPlugged = AlexaDeviceFactory.createEchoDot(false);
        AlexaDevice echoDotHybrid = AlexaDeviceFactory.createEchoDotHybrid();
        AlexaDevice echoShow = AlexaDeviceFactory.createEchoShow();
        AlexaDevice amazonEcho = AlexaDeviceFactory.createAmazonEcho();

        // Test the devices
        System.out.println("---- Testing " + echoDot.getDeviceName() + " (Battery Powered) ----");
        echoDot.processCommand("Alexa, what's your battery status?");

        System.out.println("\n---- Testing " + echoDotPlugged.getDeviceName() + " (Plug-in) ----");
        echoDotPlugged.processCommand("Alexa, what's your power status?");

        System.out.println("\n---- Testing " + echoDotHybrid.getDeviceName() + " (Hybrid) ----");
        echoDotHybrid.processCommand("Alexa, what's your battery status?");

        System.out.println("\n---- Testing " + echoShow.getDeviceName() + " ----");
        echoShow.processCommand("Alexa, what's your power status?");

        System.out.println("\n---- Testing " + amazonEcho.getDeviceName() + " ----");
        amazonEcho.processCommand("Alexa, what's your battery status?");
    }
}
