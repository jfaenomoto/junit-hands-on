package br.com.guiabolso.junit.fourth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Trainer {
    
    private String name;
    
    private List<String> pokemon;
    
    public Trainer(String name, String... pokemon) {
        this.name = name;
        this.pokemon = new LinkedList<String>(Arrays.asList(pokemon));
    }

    public String getName() {
        return name;
    }
    
    public String getActivePokemon() {
        return pokemon.get(0);
    }
    
    public void faintActivePokemon() {
        pokemon.remove(0);
    }
    
    public boolean hasPokemon() {
        return !pokemon.isEmpty();
    }
    
}
