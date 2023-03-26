package com.vasyancoder.laba2.domain.usecase;

import com.vasyancoder.laba2.domain.Repository;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

public class CreateAccountUseCase {

    private final Repository repository;

    public CreateAccountUseCase(Repository repository) {
        this.repository = repository;
    }

    public boolean createAccount(RegistrationAccount registrationAccount) {
        return repository.createAccount(registrationAccount);
    }
}
