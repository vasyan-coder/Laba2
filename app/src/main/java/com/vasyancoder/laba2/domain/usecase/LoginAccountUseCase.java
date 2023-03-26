package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.HackathonListRepository;
import com.vasyancoder.laba2.domain.UserAccountRepository;
import com.vasyancoder.laba2.domain.entity.LoginAccount;

public class LoginAccountUseCase {

    private final UserAccountRepository repository;

    public LoginAccountUseCase(UserAccountRepository repository) {
        this.repository = repository;
    }

    public boolean loginAccount(LoginAccount loginAccount) {
        return repository.loginAccount(loginAccount);
    }
}
