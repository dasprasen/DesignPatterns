package com.design.lld_Design_1;

public class EchoDot extends AlexaDevice {
    public EchoDot() {
        super("Echo Dot");
        addInputMode(new VoiceInput());
        addOutputMode(new SoundOutput());
    }
}
