package com.superdeluxebestfriends.pokeydex.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private int id;

    @Column(name = "auth_username")
    private String username;

    @Column(name = "auth_password")
    private String password;

    /*CREATE TABLE auth (auth_id SERIAL PRIMARY KEY,
			 auth_username TEXT NOT NULL,
			 auth_password TEXT NOT NULL);
			 */
}
