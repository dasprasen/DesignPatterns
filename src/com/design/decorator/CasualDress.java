package com.design.decorator;

/**
 * @author Prasenjit Kumar Das
 */
public class CasualDress extends DressDecorator {
    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding CasualDress features");
    }
}
