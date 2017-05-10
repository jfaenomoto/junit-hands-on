package br.com.guiabolso.junit;

public class PokemonProfessor {

    private int contador;

    public PokemonProfessor() {
        this.contador = 0;
    }

    String getPokemon() {
        if (contador > 5) {
            throw new IllegalStateException("no more pokemon ;(");
        }
        String pokemon;
        if (contador % 3 == 0) {
            pokemon = "Bulbasaur";
        } else if (contador % 3 == 1) {
            pokemon = "Squirtle";
        } else {
            pokemon = "Charmander";
        }
        this.contador++;
        return pokemon;
    }
}
