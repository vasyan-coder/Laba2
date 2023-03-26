package com.vasyancoder.laba2.data;

import com.vasyancoder.laba2.data.datasource.UserRemoteDataSource;
import com.vasyancoder.laba2.domain.UserAccountRepository;
import com.vasyancoder.laba2.domain.entity.LoginAccount;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

public class UserAccountRepositoryImpl implements UserAccountRepository {

    private UserRemoteDataSource userRemoteDataSource;

    @Override
    public boolean createAccount(RegistrationAccount registrationAccount) {
        return userRemoteDataSource.checkRegistrationValid(registrationAccount);
    }

    @Override
    public boolean loginAccount(LoginAccount loginAccount) {
        return userRemoteDataSource.checkLoginValid(loginAccount);
    }
}
