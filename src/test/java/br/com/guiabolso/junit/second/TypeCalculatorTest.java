package br.com.guiabolso.junit.second;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TypeCalculatorTest {

    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Grass", "Grass", "Normal" },
                { "Water", "Water", "Normal" },
                { "Fire", "Fire", "Normal" },
                
                { "Grass", "Water", "Super effective" },
                { "Water", "Fire", "Super effective" },
                { "Fire", "Grass", "Super effective" },
                
                { "Grass", "Fire", "Not very effective" },
                { "Fire", "Water", "Not very effective" },
                { "Water", "Grass", "Not very effective" }
            });
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
