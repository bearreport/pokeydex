package com.superdeluxebestfriends.pokeydex.controller;

import com.superdeluxebestfriends.pokeydex.client.AuthenticationClient;
import com.superdeluxebestfriends.pokeydex.dao.AuthRepository;
import com.superdeluxebestfriends.pokeydex.dto.AuthenticationDTO;
import com.superdeluxebestfriends.pokeydex.dto.TokenDTO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/pokeydex/auth/v1")
public class AuthController {

    @Autowired private AuthRepository       authRepository;
    @Autowired private AuthenticationClient authenticationClient;

    @PostMapping(path = "/login")
    public TokenDTO login(@RequestBody final AuthenticationDTO pAuthDTO,
        @RequestHeader(name = "Authorization", required = false) final Optional<String> pToken) {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUsername(pAuthDTO.getUsername());
        try {
            tokenDTO.setJwt(authenticationClient.authenticate(pToken.get(), pAuthDTO));
            return tokenDTO;
        }catch (final FeignException e){
            if (e.status() == HttpStatus.FORBIDDEN.value()){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }

            throw e;
        }
    }

    @PostMapping(path = "/logout")
    public TokenDTO logout(@RequestHeader(name = "Authorization", required = false) final Optional<String> pToken) {
        authenticationClient.revoke(pToken.get());
        return new TokenDTO();
    }

}