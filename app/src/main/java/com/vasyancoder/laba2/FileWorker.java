package com.vasyancoder.laba2;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.vasyancoder.laba2.data.models.RegistrationAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWorker extends Worker {
    private final Context context;

    public static final String KEY_EMAIL = "email";

    public FileWorker(@NonNull Context context,
                      @NonNull WorkerParameters workerParams
    ) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        String email = getInputData().getString(KEY_EMAIL);

        String filename = "email";
        String fileContents = email;
        File dir = context.getFilesDir();
        File file_email = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_email);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            Log.d("FileWorker", "kekekekekek");
            writer.close();
            fos.close();
            return Result.success();
        } catch (IOException e) {
            return Result.failure();
        }
    }
}
