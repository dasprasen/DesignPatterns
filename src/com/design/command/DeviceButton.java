package com.design.command;

/**
 * @author Prasenjit Kumar Das
 */
public class DeviceButton {
    private Command command;

    public DeviceButton(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public void undo() {
        command.undo();
    }
}
