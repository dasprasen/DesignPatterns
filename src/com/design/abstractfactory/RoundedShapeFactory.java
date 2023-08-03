package com.design.abstractfactory;

/**
 * @author Prasenjit Kumar Das
 */
public class RoundedShapeFactory extends AbstractFactory {
    @Override
    Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
