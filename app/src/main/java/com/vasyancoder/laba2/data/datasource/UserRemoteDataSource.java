package com.vasyancoder.laba2.data.datasource;

import android.content.Context;

import com.vasyancoder.laba2.data.models.LoginAccount;
import com.vasyancoder.laba2.data.models.RegistrationAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserRemoteDataSource {

    private final Context context;

    public UserRemoteDataSource(Context context) {
        this.context = context;
    }

    public boolean checkLoginValid(LoginAccount loginAccount) {
        return !loginAccount.getLogin().equals("") && !loginAccount.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationAccount registrationAccount) {
        String filename = "email";
        String fileContents = registrationAccount.getEmail();
        File dir = context.getFilesDir();
        File file_email = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_email);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            writer.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return !registrationAccount.getLogin().equals("") &&
                !registrationAccount.getPassword().equals("") &&
                !registrationAccount.getEmail().equals("") &&
                !registrationAccount.getPhone().equals("");
    }
}
