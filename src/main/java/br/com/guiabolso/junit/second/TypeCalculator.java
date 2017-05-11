package br.com.guiabolso.junit.second;

import java.util.Arrays;
import java.util.Vector;

public class TypeCalculator {
    
    private final static Vector<String> TYPE_INDEX =
            new Vector<>(Arrays.asList("Grass", "Water", "Fire"));
    
    private final static int[][] TYPE_MATRIX = {
        {-1, 1, -1}, // grass
        {-1, -1, 1}, // water
        {1, -1, -1}  // fire
    };

    public String damageFromTo(String typeA, String typeB) {
        int typeAIndex = TYPE_INDEX.indexOf(typeA);
        int typeBIndex = TYPE_INDEX.indexOf(typeB);
        if (TYPE_MATRIX[typeAIndex][typeBIndex] == 0) {
            return "Normal";
        } else if (TYPE_MATRIX[typeAIndex][typeBIndex] == 1) {
            return "Super effective";
        } else {
            return "Not very effective";
        }
    }
}
