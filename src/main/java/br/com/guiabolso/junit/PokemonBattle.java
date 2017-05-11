package br.com.guiabolso.junit;

public class PokemonBattle {

    private BattleSystem battleSystem;
    private ExperienceSystem expSystem;
    
    public PokemonBattle() {
        this.battleSystem = new BattleSystem();
        this.expSystem = new ExperienceSystem();
    }
    
    public Trainer battle(Trainer you, Trainer trainer) {
        while (true) {
            if (!trainer.hasPokemon()) {
                System.out.println(String.format("%s was defeated!", trainer.getName()));
                return you;
            }
            if (!you.hasPokemon()) {
                System.out.println(String.format("%s was defeated!", you.getName()));
                return trainer;
            }
            String yourPokemon = you.getPokemon().get(0);
            String trainerPokemon = trainer.getPokemon().get(0);
            String winner = this.battleSystem.winnerFrom(yourPokemon, trainerPokemon);
            if (yourPokemon.compareTo(winner) == 0) {
                trainer.getPokemon().remove(trainerPokemon);
            } else {
                you.getPokemon().remove(yourPokemon);
            }
            this.expSystem.giveExpTo(winner);
        }
    }
}
