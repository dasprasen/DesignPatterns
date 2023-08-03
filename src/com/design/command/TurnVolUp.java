package com.design.command;

/**
 * @author Prasenjit Kumar Das
 */
public class TurnVolUp implements Command {
    ElectronicDevice theDevice;

    public TurnVolUp(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.volumeUp();
    }

    @Override
    public void undo() {
        theDevice.volumeDown();
    }
}
