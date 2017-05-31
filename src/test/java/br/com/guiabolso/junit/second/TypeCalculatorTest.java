package br.com.guiabolso.junit.second;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class TypeCalculatorTest {

    @Parameters(name = "when {0} is attacking {1} its {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Grass", "Grass", "Not very effective" },
                { "Water", "Water", "Not very effective" },
                { "Fire", "Fire", "Not very effective" },
                
                { "Grass", "Water", "Super effective" },
                { "Water", "Fire", "Super effective" },
                { "Fire", "Grass", "Super effective" },
                
                { "Grass", "Fire", "Not very effective" },
                { "Fire", "Water", "Not very effective" },
                { "Water", "Grass", "Not very effective" }
            });
    }
    
    private TypeCalculator calculator;
    
    private String attackingType;
    private String defendingType;
    private String expected;
    
    public TypeCalculatorTest(String attackingType, String defendingType, String expected) {
        this.attackingType = attackingType;
        this.defendingType = defendingType;
        this.expected = expected;
    }
    
    @Before
    public void setup() {
        this.calculator = new TypeCalculator();
    }

    @Test
    public void test() {
        assertEquals(expected, this.calculator.
                damageFromTo(attackingType, defendingType));
    }

}
