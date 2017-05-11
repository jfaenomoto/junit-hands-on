package br.com.guiabolso.junit.third;

import java.util.Random;

public class BattleSystem {

    private Random random = new Random();
    
    String winnerFrom(String pokemon1, String pokemon2) {
        if (this.random.nextBoolean()) {
            System.out.println(String.format("%s fainted!", pokemon2));
            return pokemon1;
        } else {
            System.out.println(String.format("%s fainted!", pokemon1));
            return pokemon2;
        }
    }
    
}
