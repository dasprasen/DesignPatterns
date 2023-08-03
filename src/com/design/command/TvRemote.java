package com.design.command;

/**
 * @author Prasenjit Kumar Das
 */
public class TvRemote {
    public static ElectronicDevice getDevice() {
        return new Television();
    }
}
