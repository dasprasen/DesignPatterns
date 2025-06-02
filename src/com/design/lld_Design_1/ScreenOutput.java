package com.design.lld_Design_1;

public class ScreenOutput implements OutputMode {
    @Override
    public void displayOutput(String output) {
        System.out.println("Displaying on screen: " + output);
    }
}
