package com.vasyancoder.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vasyancoder.laba2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        TextView title = findViewById(R.id.title);
        binding.title.setText(R.string.authorization);

//        ImageView logoImage = findViewById(R.id.logoImage);
        binding.logoImage.setImageResource(R.drawable.alpha_logo);

//        Button signInButton = findViewById(R.id.signInButton);
        // programmaly set click
        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "click :)");
            }
        });
    }

    // declarative set click
//    public void signInClick(View view) {
//        Log.d(TAG, "click :)");
//    }
}