package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.Repository;
import com.vasyancoder.laba2.domain.entity.LoginAccount;

public class LoginAccountUseCase {

    private final Repository repository;

    public LoginAccountUseCase(Repository repository) {
        this.repository = repository;
    }

    public boolean loginAccount(LoginAccount loginAccount) {
        return repository.loginAccount(loginAccount);
    }
}
