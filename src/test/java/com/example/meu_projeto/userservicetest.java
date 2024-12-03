package com.example.meu_projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;


public class userservicetest {
    private userservice userService = new userservice();

    @Test
    public void createUser_ValidData() {
        user user = new user("test@example.com", "12345678");
        List<user> users = userService.create(user);
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
    }

    @Test
    public void createUser_DuplicateEmail() {
        user user = new user("test@example.com", "12345678");
        userService.create(user);
        assertThrows(RuntimeException.class, () -> userService.create(user));
    }

    @Test
    public void createUser_ShortPassword() {
        user user = new user("test@example.com", "123");
        assertThrows(RuntimeException.class, () -> userService.create(user));
    }

    @Test
    public void login_Successful() {
        user user = new user("test@example.com", "12345678");
        userService.create(user);
        assertTrue(userService.login("test@example.com", "12345678"));
    }

    @Test
    public void login_WrongPassword() {
        user user = new user("test@example.com", "12345678");
        userService.create(user);
        assertFalse(userService.login("test@example.com", "wrongpassword"));
    }

    @Test
    public void login_EmailNotRegistered() {
        assertFalse(userService.login("notregistered@example.com", "12345678"));
    }
    @Test
public void createUser_ExactPasswordLength() {
    user user = new user("test@example.com", "12345678");
    List<user> users = userService.create(user);
    assertEquals(1, users.size());
    assertEquals(user, users.get(0));
}
@Test
public void createUser_EmptyEmail() {
    user user = new user("", "12345678");
    assertThrows(RuntimeException.class, () -> userService.create(user), "Email não pode ser vazio.");
}
@Test
public void createUser_EmptyPassword() {
    user user = new user("test@example.com", "");
    assertThrows(RuntimeException.class, () -> userService.create(user), "Senha não pode ser vazia.");
}


}
