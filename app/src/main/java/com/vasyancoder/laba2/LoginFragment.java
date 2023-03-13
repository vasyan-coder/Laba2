package com.vasyancoder.laba2;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.vasyancoder.laba2.databinding.FragmentBottomNavBinding;
import com.vasyancoder.laba2.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    private int maxLayoutHeight = 0;

    private static final String TAG = "LoginFragment";
    public static final String KEY_BUNDLE_EMAIL = "user_email";
    public static final String KEY_BUNDLE_PASS = "user_pass";
    public static final String KEY_LOGIN = "user_login";
    public static final String KEY_RESULT = "requestKey";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentResultListener();
        parseArgs();

        setButtonClickListeners();

        clearListenerLoginError();
        clearListenerPasswordError();

        scrollDownWhenOpenKeyboard();

    }

    private void setButtonClickListeners() {
        binding.logInButton.setOnClickListener(view1 -> checkFields());
        binding.registration.setOnClickListener(
                view12 -> requireActivity().getSupportFragmentManager().beginTransaction()

                        .replace(R.id.container_fragment, RegistrationFragment.newInstance())
                        .addToBackStack(null)
                        .commit());
    }

    private void scrollDownWhenOpenKeyboard() {
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(() -> {
            int heightDiff = binding.getRoot().getHeight();
            if (heightDiff > maxLayoutHeight)
                maxLayoutHeight = heightDiff;
            Log.d(TAG, "Layout height = " + heightDiff);
            if (heightDiff < maxLayoutHeight) {
                Log.d(TAG, "Open keyboard");
                scrollDownToMyPos();
            }
        });
    }

    private void fragmentResultListener() {
        getParentFragmentManager().setFragmentResultListener(KEY_RESULT, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                binding.etPassword.setText("");                   // clear password
                String userLogin = result.getString(KEY_LOGIN);
                binding.etLogin.setText(userLogin);
                binding.etLogin.setSelection(userLogin.length()); // position cursor at end of text
                binding.etLogin.requestFocus();                   // focus on etLogin
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

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, new BottomNavFragment())
                    .addToBackStack(null)
                    .commit();

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

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String email = bundle.getString(KEY_BUNDLE_EMAIL);
            String pass = bundle.getString(KEY_BUNDLE_PASS);
            binding.etLogin.setText(email);
            binding.etPassword.setText(pass);
        }
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    public static LoginFragment newInstance(String email, String pass) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BUNDLE_EMAIL, email);
        bundle.putString(KEY_BUNDLE_PASS, pass);
        loginFragment.setArguments(bundle);
        return loginFragment;
    }
}
