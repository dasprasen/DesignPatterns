package com.design.lld_Design_1;

public class VoiceInput implements InputMode {
    @Override
    public void processInput(String input) {
        System.out.println("Processing voice input: " + input);
    }
}
