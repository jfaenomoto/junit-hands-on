package br.com.guiabolso.junit.fourth;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class PokemonBattleTest {
    
    private PokemonBattle battle;
    private BattleSystem battleSystem;
    private ExperienceSystem experienceSystem;
    
    @Test
    public void noOpponentYouWin() {
        // given
        Trainer you = new Trainer("Rafael", "Hypno", "Rattata");
        Trainer trainer = new Trainer("Swimmer");
        // when
        Trainer winner = this.battle.battle(you, trainer);
        // then
        assertEquals(you, winner);
    }
    
    @Test
    public void blackedOutOpponentWins() {
        // given
        Trainer you = new Trainer("Alberto");
        Trainer trainer = new Trainer("Swimmer", "Staryu");
        // when
        Trainer winner = this.battle.battle(you, trainer);
        // then
        assertEquals(trainer, winner);
    }
    
    @Test
    public void youWin() {
        // given
        Trainer you = new Trainer("Carol", "Charmander", "Geodude");
        Trainer trainer = new Trainer("Swimmer", "Magikarp");
        // and
        when(this.battleSystem.winnerFrom("Charmander", "Magikarp")).thenReturn("Magikarp");
        when(this.battleSystem.winnerFrom("Geodude", "Magikarp")).thenReturn("Geodude");
        // when
        Trainer winner = this.battle.battle(you, trainer);
        // then
        assertEquals(you, winner);
        // and
        verify(this.experienceSystem).giveExpTo("Magikarp");
        verify(this.experienceSystem).giveExpTo("Geodude");
    }
    
    @Test
    public void opponentWins() {
        // given
        Trainer you = new Trainer("José", "Squirtle", "Mewtwo");
        Trainer trainer = new Trainer("Swimmer", "Lapras");
        // and
        when(this.battleSystem.winnerFrom("Squirtle", "Lapras")).thenReturn("Lapras");
        when(this.battleSystem.winnerFrom("Mewtwo", "Lapras")).thenReturn("Lapras");
        // when
        Trainer winner = this.battle.battle(you, trainer);
        // then
        assertEquals(trainer, winner);
        // and
        verify(this.experienceSystem, times(2)).giveExpTo("Lapras");
    }
    
    @Before
    public void hereComesANewChallenger() {
        this.battleSystem = mock(BattleSystem.class);
        this.experienceSystem = mock(ExperienceSystem.class);
        this.battle = new PokemonBattle(this.battleSystem, this.experienceSystem);
    }

}
