package com.tecocraft.demoauthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tecocraft.authlibrary.Authentication;

import java.util.regex.Pattern;

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

            if (!strEmail.isEmpty() && !strPassword.isEmpty()) {
                if (!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()) {
                    Toast.makeText(getApplicationContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                    email.setText("");
                } else if (!Pattern.matches("(?=.*?[a-z])(?=.*?[0-9]).{6,}$", strPassword)) {
                    Toast.makeText(getApplicationContext(), "Password should be atleast 6 character long and contains alphabets and digits", Toast.LENGTH_SHORT).show();
                    password.setText("");
                }else if(Authentication.verifyCredential(strEmail,strPassword))
                {
                    Toast.makeText(getApplicationContext(), "You are successfully authenticated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                    i.putExtra("username",strEmail);
                    startActivity(i);
                    finish();

                }else {
                    email.setText("");
                    password.setText("");
                    Toast.makeText(getApplicationContext(), "Sorry!! This credential are not valid", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
