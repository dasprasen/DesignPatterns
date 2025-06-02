package com.design.lld_Design_1;

public class BatteryPower implements PowerSource {
    private int batteryPercentage;

    public BatteryPower(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void setBatteryPercentage(int percentage) {
        this.batteryPercentage = percentage;
    }

    @Override
    public String getPowerStatus() {
        return batteryPercentage + "% charged";
    }
}
