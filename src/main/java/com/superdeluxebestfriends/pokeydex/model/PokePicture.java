package com.superdeluxebestfriends.pokeydex.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="pokepictures")
@Data
public class PokePicture
{
    @Column(name = "picture_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pokemon_id")
    private int pokemonId;

    @Column(name="picture_url")
    private String pictureUrl;

}

/*--CREATE TABLE pokepictures (
	picture_id SERIAL PRIMARY KEY,
	pokemon_id INT NOT NULL,
	picture_url VARCHAR(1024) NOT NULL,
	FOREIGN KEY (pokemon_id)
		REFERENCES pokemon (pokemon_id)
)--*/