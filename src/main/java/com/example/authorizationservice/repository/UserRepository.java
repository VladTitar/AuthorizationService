package com.example.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import com.example.authorizationservice.exceptions.UnauthorizedUser;
import com.example.authorizationservice.model.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    public Map<String,String> credentials = new HashMap<>();
    public Map<String, List<Authorities>> authorities = new HashMap<>();
    public List<Authorities> getUserAuthorities(String user, String password) {

        // Для тестирования
        String testUsername = "Vladislav";
        String testPassword = "Qwerty";
        List<Authorities> testAuthorities = List.of(Authorities.READ,Authorities.DELETE);
        credentials.put(testUsername, testPassword);
        authorities.put(testUsername, testAuthorities);

        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return authorities.get(user);
        }
        return Collections.emptyList();
    }
}