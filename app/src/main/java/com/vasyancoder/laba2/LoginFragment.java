package com.vasyancoder.laba2;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vasyancoder.laba2.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private int maxLayoutHeight = 0;

    private static final String TAG = "LoginFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
                int heightDiff = binding.getRoot().getHeight();
                if (heightDiff > maxLayoutHeight)
                    maxLayoutHeight = heightDiff;
                Log.d(TAG, "Layout height = " + heightDiff);
                if (heightDiff < maxLayoutHeight) {
                    Log.d(TAG, "Open keyboard");
                    scrollDownToMyPos();
                }
            }
        });
    }

    private void scrollDownToMyPos() {
        binding.scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.scrollView.smoothScrollBy(0, (int) binding.logInButton.getY());
            }
        }, 0);
    }

    private void checkFields() {
        if (binding.etLogin.getText().toString().length() != 0 &&
                binding.etPassword.getText().toString().length() != 0) {


//            startForResult.launch(UserActivity.newIntentLogin(
//                    LoginActivity.this,
//                    binding.etLogin.getText().toString()));
        } else if (binding.etLogin.getText().toString().length() == 0 &&
                binding.etPassword.getText().toString().length() != 0) {

            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
        } else if (binding.etPassword.getText().toString().length() == 0 &&
                binding.etLogin.getText().toString().length() != 0) {

            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
        } else {
            binding.etPasswordLayout.setHelperText(getString(R.string.warning_fill));
            binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
            binding.etLoginLayout.setHelperText(getString(R.string.warning_fill));
            binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
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
                    binding.etLoginLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
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
                binding.etPasswordLayout.setHelperTextColor(ColorStateList.valueOf(requireContext().getColor(R.color.red)));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
