package com.superdeluxebestfriends.pokeydex.dao;

import com.superdeluxebestfriends.pokeydex.model.Auth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Integer> {

    @Query( value = "SELECT * FROM auth WHERE (auth_username = :pUsername)",
        nativeQuery = true  )
    Optional<Auth> login(final String pUsername);

}
