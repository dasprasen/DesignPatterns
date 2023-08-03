package com.design.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Prasenjit Kumar Das
 */
public class ColorStore {
    private static Map<String, Color> colorMap = new HashMap<String, Color>();

    static
    {
        colorMap.put("blue", new BlueColor());
        colorMap.put("black", new BlackColor());
    }

    public static Color getColor(String colorName)
    {
        return (Color) colorMap.get(colorName).clone();
    }
}
