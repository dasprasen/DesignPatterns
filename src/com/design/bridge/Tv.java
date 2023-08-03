package com.design.bridge;

/**
 * @author Prasenjit Kumar Das
 */
abstract class Tv {
    Remote remote;

    Tv(Remote r) {
        this.remote = r;
    }
    abstract void on();
    abstract void off();
}
