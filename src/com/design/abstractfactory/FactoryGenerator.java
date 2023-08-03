package com.design.abstractfactory;

/**
 * @author Prasenjit Kumar Das
 */
public class FactoryGenerator {
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory();
        }
    }
}
