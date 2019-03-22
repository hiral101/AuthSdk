package com.tecocraft.demoauthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tecocraft.authlibrary.Authentication;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email, password;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.email_sign_in_button);
        btnSignIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.email_sign_in_button) {

            String strEmail = email.getText().toString();
            String strPassword = password.getText().toString();

            String error = Authentication.Validate(strEmail, strPassword);
            if (error.isEmpty()) {
                if (Authentication.verifyCredential(strEmail, strPassword)) {
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtra("username",strEmail);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Sorry! this credentials are not valid", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
