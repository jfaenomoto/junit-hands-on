package br.com.guiabolso.junit.third;

import java.util.List;

public class PokeCenter {

    private HealingMachine machine;
    
    public PokeCenter() {
        this.machine = new HealingMachine();
    }
    
    public PokeCenter(HealingMachine machine) {
        this.machine = machine;
    }
    
    void heal(List<Pokeball> pokeballs) {
        if (pokeballs == null) {
            throw new IllegalArgumentException("pokeball list can't be null");
        }
        for (Pokeball pokeball : pokeballs) {
            this.machine.heal(pokeball.getPokemon());
        }
    }
    
}
