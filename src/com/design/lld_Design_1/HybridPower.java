package com.design.lld_Design_1;

public class HybridPower implements PowerSource {
    private BatteryPower battery;
    private PlugInPower plugIn;

    public HybridPower(BatteryPower battery, PlugInPower plugIn) {
        this.battery = battery;
        this.plugIn = plugIn;
    }

    @Override
    public String getPowerStatus() {
        if (plugIn != null && plugIn.getPowerStatus().equals("plugged-in")) {
            return "plugged-in, battery at " + battery.getPowerStatus();
        } else {
            return battery.getPowerStatus();
        }
    }
}
