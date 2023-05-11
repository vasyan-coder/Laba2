package com.vasyancoder.laba2.data.datasource;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.vasyancoder.laba2.FileWorker;
import com.vasyancoder.laba2.data.models.LoginAccount;
import com.vasyancoder.laba2.data.models.RegistrationAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserRemoteDataSource {

    private final WorkManager mWorkManager;

    public UserRemoteDataSource(Context context) {
        mWorkManager = WorkManager.getInstance(context);
    }

    public boolean checkLoginValid(LoginAccount loginAccount, boolean allowed) {
//        if (allowed) {
//            String filename = "login";
//            String fileContents = loginAccount.getLogin();
//            File file_login = new File("/storage/emulated/0/Android/data", filename);
//            try {
//                FileOutputStream fos = new FileOutputStream(file_login);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                writer.write(fileContents);
//                writer.close();
//                fos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        return !loginAccount.getLogin().equals("") && !loginAccount.getPassword().equals("");
    }

    private Data createInputData(String email) {
        Data.Builder builder = new Data.Builder();
        builder.putString(FileWorker.KEY_EMAIL, email);
        return builder.build();
    }

    public boolean checkRegistrationValid(RegistrationAccount registrationAccount) {
        OneTimeWorkRequest fileRequest =
                new OneTimeWorkRequest.Builder(FileWorker.class)
                        .setInputData(createInputData(registrationAccount.getEmail()))
                        .build();
        mWorkManager.enqueue(fileRequest);

//        String filename = "email";
//        String fileContents = registrationAccount.getEmail();
//        File dir = context.getFilesDir();
//        File file_email = new File(dir, filename);
//        try {
//            FileOutputStream fos = new FileOutputStream(file_email);
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//            writer.write(fileContents);
//            writer.close();
//            fos.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        return !registrationAccount.getLogin().equals("") &&
                !registrationAccount.getPassword().equals("") &&
                !registrationAccount.getEmail().equals("") &&
                !registrationAccount.getPhone().equals("");
    }
}
