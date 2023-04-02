package com.vasyancoder.laba2.ui.stateholder.viewmodel;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
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


    public boolean loginAccount(String login, String pass, boolean allowed) {
        boolean fieldsValid = validateInput(login, pass);
        if (fieldsValid) {
            LoginAccount loginAccount = new LoginAccount(login, pass);
            return repository.loginAccount(loginAccount, allowed);
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
