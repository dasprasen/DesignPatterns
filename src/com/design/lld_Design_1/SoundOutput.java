package com.design.lld_Design_1;

public class SoundOutput implements OutputMode {
    @Override
    public void displayOutput(String output) {
        System.out.println("Playing through speaker: " + output);
    }
}
