package com.design.lld_Design_1;

public class PlugInPower implements PowerSource {
    private boolean isPluggedIn;

    public PlugInPower(boolean isPluggedIn) {
        this.isPluggedIn = isPluggedIn;
    }

    public void setPluggedIn(boolean pluggedIn) {
        this.isPluggedIn = pluggedIn;
    }

    @Override
    public String getPowerStatus() {
        return isPluggedIn ? "plugged-in" : "not plugged-in";
    }
}
