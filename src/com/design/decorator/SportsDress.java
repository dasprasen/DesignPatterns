package com.design.decorator;

/**
 * @author Prasenjit Kumar Das
 */
public class SportsDress extends DressDecorator {
    public SportsDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding SportsDress features");
    }
}
