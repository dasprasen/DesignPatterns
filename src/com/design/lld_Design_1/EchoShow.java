package com.design.lld_Design_1;

public class EchoShow extends AlexaDevice {
    public EchoShow() {
        super("Echo Show");
        addInputMode(new VoiceInput());
        addInputMode(new TypeInput());
        addOutputMode(new SoundOutput());
        addOutputMode(new ScreenOutput());
    }
}
