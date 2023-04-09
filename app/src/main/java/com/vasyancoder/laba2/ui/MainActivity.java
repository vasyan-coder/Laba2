package com.vasyancoder.laba2.ui;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.vasyancoder.laba2.R;
import com.vasyancoder.laba2.databinding.ActivityMainBinding;
import com.vasyancoder.laba2.ui.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHost =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment);
        NavGraph graph = navHost.getNavController()
                .getNavInflater().inflate(R.navigation.start_nav_graph);

        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.equalsIgnoreCase("text/plain")) {
                    String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
                    Bundle bundle = new Bundle();
                    bundle.putString(LoginFragment.KEY_LOGIN, textData);
                    graph.setStartDestination(R.id.loginFragment);
                    navHost.getNavController().setGraph(graph, bundle);
                }
            } else {
                graph.setStartDestination(R.id.greetingFragment);
                navHost.getNavController().setGraph(graph);
            }
        }
    }
}