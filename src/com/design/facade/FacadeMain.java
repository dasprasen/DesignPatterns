package com.design.facade;

/**
 * @author Prasenjit Kumar Das
 */
public class FacadeMain {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCircle();
        shapeFacade.drawRectangle();
        shapeFacade.drawSquare();
    }
}
