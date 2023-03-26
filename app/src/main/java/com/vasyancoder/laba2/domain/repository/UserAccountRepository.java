package com.vasyancoder.laba2.domain.repository;

import com.vasyancoder.laba2.domain.entity.LoginAccount;
import com.vasyancoder.laba2.domain.entity.RegistrationAccount;

public interface UserAccountRepository {

    boolean createAccount(RegistrationAccount registrationAccount);

    boolean loginAccount(LoginAccount loginAccount);

}
