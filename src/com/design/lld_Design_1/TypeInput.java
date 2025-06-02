package com.design.lld_Design_1;

public class TypeInput implements InputMode {
    @Override
    public void processInput(String input) {
        System.out.println("Processing typed input: " + input);
    }
}
