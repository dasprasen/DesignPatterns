package com.design.command;

/**
 * @author Prasenjit Kumar Das
 */
public interface Command {
    public void execute();

    public void undo();
}
