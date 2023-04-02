package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vasyancoder.laba2.data.repositories.UserAccountRepository;
import com.vasyancoder.laba2.data.models.LoginAccount;
import com.vasyancoder.laba2.data.protocols.UserAccountProtocol;

public class LoginViewModel extends AndroidViewModel {

    private final UserAccountProtocol repository = new UserAccountRepository(getApplication());

    private final MutableLiveData<Boolean> _errorInputLogin = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> errorInputLogin() {
        return _errorInputLogin;
    }

    private final MutableLiveData<Boolean> _errorInputPass = new MutableLiveData<>();

    public LiveData<Boolean> errorInputPass() {
        return _errorInputPass;
    }


    public boolean loginAccount(String login, String pass) {
        boolean fieldsValid = validateInput(login, pass);
        if (fieldsValid) {
            LoginAccount loginAccount = new LoginAccount(login, pass);
            return repository.loginAccount(loginAccount);
        }
        return false;
    }

    private boolean validateInput(String login, String pass) {
        boolean result = true;
        if (login.equals("")) {
            _errorInputLogin.setValue(true);
            result = false;
        }
        if (pass.equals("")) {
            _errorInputPass.setValue(true);
            result = false;
        }
        return result;
    }

    public void resetErrorInputLogin() {
        _errorInputLogin.setValue(false);
    }

    public void resetErrorInputPass() {
        _errorInputPass.setValue(false);
    }
}
