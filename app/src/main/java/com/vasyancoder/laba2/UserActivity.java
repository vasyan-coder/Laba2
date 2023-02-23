package com.vasyancoder.laba2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vasyancoder.laba2.databinding.AcitivityUserBinding;

public class UserActivity extends AppCompatActivity {

    public static final String KEY_NAME = "user_login";

    private final String TAG = "UserActivity";

    private AcitivityUserBinding binding;
    private String userLogin = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = AcitivityUserBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultActivity();
            }
        });

        parseIntent();
    }

    private void parseIntent() {
        if (!getIntent().hasExtra(KEY_NAME)) {
            throw new RuntimeException("Login doesn't input");
        }
        userLogin = getIntent().getStringExtra(KEY_NAME);
        binding.welcomeTextView.setText(getString(R.string.welcome, userLogin));
    }

    @Override
    public void onBackPressed() {
        resultActivity();
        super.onBackPressed();
    }

    private void resultActivity() {
        Intent intent = new Intent();
        intent.putExtra(KEY_NAME, userLogin);
        setResult(RESULT_OK, intent);
        finish();
    }

    public static Intent newIntentLogin(Context context, String userLogin) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(KEY_NAME, userLogin);
        return intent;
    }
}
