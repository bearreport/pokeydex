package com.superdeluxebestfriends.pokeydex.client;

import com.superdeluxebestfriends.pokeydex.dto.AuthenticationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AuthenticationClient", url = "${auth.host}")
public interface AuthenticationClient {

    @PostMapping("/auth/v1/auth")
    String authenticate(
        @RequestHeader("Authorization")   final String pToken,
        @RequestBody                      final AuthenticationDTO pAuthDTO
                       );


    @PostMapping("/auth/v1/validate")
    public void validate(
        @RequestHeader("Authorization")   final String pToken
                        );

    @PostMapping("/auth/v1/revoke")
    public void revoke(
        @RequestHeader("Authorization")   final String pToken
                      );
}
