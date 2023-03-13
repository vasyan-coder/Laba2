package com.vasyancoder.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vasyancoder.laba2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.container_fragment, GreetingFragment.class, null)
                    .commit();
        }
    }
}