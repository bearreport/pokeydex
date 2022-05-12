package com.superdeluxebestfriends.pokeydex.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pokemon")
@Data
public class Pokemon
{
    @Column(name="pokemon_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="tattooed")
    private boolean tattooed;
}


/*--CREATE TABLE pokemon (
	pokemon_id serial PRIMARY KEY,
	name VARCHAR (50) UNIQUE NOT NULL,
	tattooed BOOLEAN NOT NULL) --*/