package com.tecocraft.demoauthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvWelcome = findViewById(R.id.tvWelcome);
        tvWelcome.setText("Welcome"+ " " + getIntent().getStringExtra("username"));
    }
}
