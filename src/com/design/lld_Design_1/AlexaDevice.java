package com.design.lld_Design_1;

import java.util.ArrayList;
import java.util.List;

abstract class AlexaDevice {
    protected List<InputMode> inputModes;
    protected List<OutputMode> outputModes;
    protected PowerSource powerSource;
    protected String deviceName;

    public AlexaDevice(String deviceName) {
        this.deviceName = deviceName;
        this.inputModes = new ArrayList<>();
        this.outputModes = new ArrayList<>();
    }

    public void addInputMode(InputMode inputMode) {
        inputModes.add(inputMode);
    }

    public void addOutputMode(OutputMode outputMode) {
        outputModes.add(outputMode);
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void processCommand(String command) {
        for (InputMode inputMode : inputModes) {
            inputMode.processInput(command);
        }

        if (command.toLowerCase().contains("battery status") ||
                command.toLowerCase().contains("power status")) {
            respondWithPowerStatus();
        } else {
            String response = "I'm sorry, I don't understand that command.";
            for (OutputMode outputMode : outputModes) {
                outputMode.displayOutput(response);
            }
        }
    }

    public void respondWithPowerStatus() {
        String status = powerSource.getPowerStatus();

        for (OutputMode outputMode : outputModes) {
            if (outputMode instanceof ScreenOutput) {
                outputMode.displayOutput("Battery Status: " + status);
            } else if (outputMode instanceof SoundOutput) {
                outputMode.displayOutput("Your device is " + status);
            }
        }
    }
}
