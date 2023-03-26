package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.repository.UserAccountRepository;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

public class CreateAccountUseCase {

    private final UserAccountRepository repository;

    public CreateAccountUseCase(UserAccountRepository repository) {
        this.repository = repository;
    }

    public boolean createAccount(RegistrationAccount registrationAccount) {
        return repository.createAccount(registrationAccount);
    }
}
