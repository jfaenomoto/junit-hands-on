package br.com.guiabolso.junit;

import java.util.List;

public class PokeCenter {

    private HealingMachine machine;
    
    public PokeCenter() {
        this.machine = new HealingMachine();
    }
    
    void heal(List<Pokeball> pokeballs) {
        for (Pokeball pokeball : pokeballs) {
            this.machine.heal(pokeball.getPokemon());
        }
    }
    
}
