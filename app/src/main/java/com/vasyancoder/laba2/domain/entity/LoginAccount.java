package com.vasyancoder.laba2.domain.entity;

public class LoginAccount {
    private final String login;
    private final String password;

    public LoginAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
