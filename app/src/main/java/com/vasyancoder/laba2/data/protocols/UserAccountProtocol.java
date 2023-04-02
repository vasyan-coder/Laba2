package com.vasyancoder.laba2.data.protocols;

import com.vasyancoder.laba2.data.models.LoginAccount;
import com.vasyancoder.laba2.data.models.RegistrationAccount;

public interface UserAccountProtocol {

    boolean createAccount(RegistrationAccount registrationAccount);

    boolean loginAccount(LoginAccount loginAccount, boolean allowed);

}
