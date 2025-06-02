package com.design.lld_Design_1;

public class AmazonEcho extends AlexaDevice {
    public AmazonEcho() {
        super("Amazon Echo");
        addInputMode(new VoiceInput());
        addOutputMode(new SoundOutput());
    }
}
