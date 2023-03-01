package com.vasyancoder.laba2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

import com.vasyancoder.laba2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private ActivityLoginBinding binding;


    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null && result.getResultCode() == RESULT_OK) {
                        if (result.getData() != null && result.getData().getStringExtra(UserActivity.KEY_NAME) != null) {
                            binding.etPassword.setText("");                   // clear password
                            String userLogin = result.getData().getStringExtra(UserActivity.KEY_NAME);
                            binding.etLogin.setText(userLogin);
                            binding.etLogin.setSelection(userLogin.length()); // position cursor at end of text

                            binding.etLogin.requestFocus();                   // focus on etLogin
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.showSoftInput(binding.etLogin, InputMethodManager.SHOW_IMPLICIT);
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TextView title = findViewById(R.id.title);
        binding.title.setText(R.string.authorization);

        //ImageView logoImage = findViewById(R.id.logoImage);
        binding.logoImage.setImageResource(R.drawable.alpha_logo);

        //Button signInButton = findViewById(R.id.signInButton);
        // programmaly set click
        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkFields();
            }
        });

        clearListenerLoginError();
        clearListenerPasswordError();

        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightDiff = binding.getRoot().getHeight() - binding.getRoot().getHeight();
                if (heightDiff < 100) {
                    scrollUpToMyPos();
                }
            }
        });

    }

    private boolean scrollUpToMyPos() {
        return binding.scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.scrollView.smoothScrollBy(0, (int) binding.logInButton.getY());
            }
        }, -2000000000);
    }

    private void checkFields() {
        if (binding.etLogin.getText().toString().length() != 0 &&
                binding.etPassword.getText().toString().length() != 0) {

            startForResult.launch(UserActivity.newIntentLogin(
                    LoginActivity.this,
                    binding.etLogin.getText().toString()));
        } else if (binding.etLogin.getText().toString().length() == 0 &&
                binding.etPassword.getText().toString().length() != 0) {

            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
        } else if (binding.etPassword.getText().toString().length() == 0 &&
                binding.etLogin.getText().toString().length() != 0) {

            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
        } else {
            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
        }
    }

    private void clearListenerLoginError() {
        binding.etLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    binding.etLoginLayout.setHelperText("");
                    binding.etLoginLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void clearListenerPasswordError() {
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.etPasswordLayout.setHelperText("");
                binding.etPasswordLayout.setHelperTextColor(getResources().getColorStateList(R.color.red));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    // declarative set click
    //public void signInClick(View view) {
    //    Log.d(TAG, "click :)");
    //}
}