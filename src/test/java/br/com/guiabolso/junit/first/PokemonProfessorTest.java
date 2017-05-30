package br.com.guiabolso.junit.first;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokemonProfessorTest {
    
    private PokemonProfessor professor;
    
    @Test
    public void getBulbasaur() {
        // when
        String myPokemon = this.professor.getPokemon();
        // then
        assertEquals("Bulbasaur", myPokemon);
    }
    
    @Test
    public void getSquirtle() {
        // given
        this.professor.getPokemon();
        // when
        String myPokemon = this.professor.getPokemon();
        // then
        assertEquals("Squirtle", myPokemon);
    }
    
    @Test
    public void getCharmander() {
        // given
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        // when
        String myPokemon = this.professor.getPokemon();
        // then
        assertEquals("Charmander", myPokemon);
    }
    
    @Test(expected = IllegalStateException.class)
    public void outOfPokemon() {
        // given
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        this.professor.getPokemon();
        // when
        this.professor.getPokemon();
    }
    
    @Before
    public void getProfessorReady() {
        this.professor = new PokemonProfessor();
    }

}
