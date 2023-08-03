package com.design.decorator;

/**
 * @author Prasenjit Kumar Das
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Dress sportsDress = new SportsDress(new BasicDress());
        sportsDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportsFancyDress = new SportsDress(new FancyDress(new BasicDress()));
        sportsFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
        System.out.println();
    }
}
