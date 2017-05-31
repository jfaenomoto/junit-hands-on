package br.com.guiabolso.junit.first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokemonProfessorTest {
    
    PokemonProfessor pp;
    
    @Before
    public void setUp() {
        this.pp = new PokemonProfessor();
    }
    
    @Test
    public void testGetBulbasaur() {        
        String pokemon = pp.getPokemon();
        
        assertEquals("Bulbasaur", pokemon);
    }
    
    @Test
    public void testGetSquirtle() {
        this.pp.getPokemon();
        String pokemon = pp.getPokemon();
        
        assertEquals("Squirtle", pokemon);
    }
    
    @Test
    public void testGetCharmander() {
        this.pp.getPokemon();
        this.pp.getPokemon();
        String pokemon = this.pp.getPokemon();
        
        assertEquals("Charmander", pokemon);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testThrowsExceptionIfMoreThan6PokemonsAreRequested() {
        this.pp.getPokemon();
        this.pp.getPokemon();
        this.pp.getPokemon();

        this.pp.getPokemon();
        this.pp.getPokemon();
        this.pp.getPokemon();
        
        this.pp.getPokemon();
    }
}
