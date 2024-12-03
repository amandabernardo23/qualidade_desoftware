package com.example.meu_projeto;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    private List<user> users = new ArrayList<>();

    public List<user> create(user user) {
        if (users.stream().anyMatch(u -> u.username().equals(user.username()))) {
            throw new RuntimeException("Email já cadastrado.");
        }
        if (user.password().length() < 8) {
            throw new RuntimeException("Senha deve ter no mínimo 8 caracteres.");
        }
        if (user.username().isEmpty()) {
            throw new RuntimeException("Email não pode ser vazio.");
        }
        users.add(user);
        return users;
    }

    public boolean login(String username, String password) {
        return users.stream().anyMatch(u -> u.username().equals(username) && u.password().equals(password));
    }
}

