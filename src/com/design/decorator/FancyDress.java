package com.design.decorator;

/**
 * @author Prasenjit Kumar Das
 */
public class FancyDress extends DressDecorator {
    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding FancyDress Features");
    }
}
