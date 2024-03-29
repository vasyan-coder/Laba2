package com.vasyancoder.laba2.data.repositories;

import android.content.Context;

import com.vasyancoder.laba2.data.datasource.UserRemoteDataSource;
import com.vasyancoder.laba2.data.protocols.UserAccountProtocol;
import com.vasyancoder.laba2.data.models.LoginAccount;
import com.vasyancoder.laba2.data.models.RegistrationAccount;

public class UserAccountRepository implements UserAccountProtocol {

    private final UserRemoteDataSource userRemoteDataSource;

    public UserAccountRepository(Context context) {
        this.userRemoteDataSource = new UserRemoteDataSource(context);
    }

    @Override
    public boolean createAccount(RegistrationAccount registrationAccount) {
        return userRemoteDataSource.checkRegistrationValid(registrationAccount);
    }

    @Override
    public boolean loginAccount(LoginAccount loginAccount, boolean allowed) {
        return userRemoteDataSource.checkLoginValid(loginAccount, allowed);
    }
}
