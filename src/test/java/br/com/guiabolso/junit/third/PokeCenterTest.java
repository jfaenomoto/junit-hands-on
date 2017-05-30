package br.com.guiabolso.junit.third;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PokeCenterTest {
    
    private PokeCenter center;
    private HealingMachine mockMachine;
    
    @Test
    public void healAllPokemon() {
        // given
        List<Pokeball> pokemon = Arrays.asList(
                new Pokeball("Pikachu"),
                new Pokeball("Pidgey"),
                new Pokeball("Kakuna")
            );
        // when
        this.center.heal(pokemon);
        // then
        verify(this.mockMachine).heal("Pikachu");
        verify(this.mockMachine).heal("Pidgey");
        verify(this.mockMachine).heal("Kakuna");
        // or
        verify(this.mockMachine, times(3)).heal(anyString());
    }
    
    @Test
    public void dontHealIfNoPokemon() {
        // when
        this.center.heal(Collections.<Pokeball> emptyList());
        // then
        verify(this.mockMachine, times(0)).heal(anyString());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void dontHealIfNullList() {
        // when
        this.center.heal(null);
    }
    
    @Before
    public void buildCenter() {
        mockMachine = mock(HealingMachine.class);
        this.center = new PokeCenter(mockMachine);
    }

}
