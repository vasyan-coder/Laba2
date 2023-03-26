package com.vasyancoder.laba2.data.datasource;

import com.vasyancoder.laba2.domain.entity.LoginAccount;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

public class UserRemoteDataSource {

    public boolean checkLoginValid(LoginAccount loginAccount) {
        return !loginAccount.getLogin().equals("") && !loginAccount.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationAccount registrationAccount) {
        return !registrationAccount.getLogin().equals("") &&
                !registrationAccount.getPassword().equals("") &&
                !registrationAccount.getEmail().equals("") &&
                !registrationAccount.getPhone().equals("");
    }

}
