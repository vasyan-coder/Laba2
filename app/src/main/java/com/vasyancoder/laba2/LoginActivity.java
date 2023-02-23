package com.vasyancoder.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView title = findViewById(R.id.title);
        title.setText(R.string.authorization);

        ImageView logoImage = findViewById(R.id.logoImage);
        logoImage.setImageResource(R.drawable.alpha_logo);


    }
}