package com.superdeluxebestfriends.pokeydex.dto;

import com.superdeluxebestfriends.pokeydex.model.Pokemon;
import lombok.Data;
import lombok.val;

@Data
public class PokemonDTO
{
    private int id;
    private String name;
    private boolean tattooed;

    private static PokemonDTO of(final Pokemon pPokemon) {
        val pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pPokemon.getId());
        pokemonDTO.setName(pPokemon.getName());
        pokemonDTO.setTattooed(pPokemon.isTattooed());

        return pokemonDTO;
    }

    public Pokemon toPokemon() {
        val pokemon = new Pokemon();
        pokemon.setId(getId());
        pokemon.setName(getName());
        pokemon.setTattooed(isTattooed());

        return pokemon;
    }
}

