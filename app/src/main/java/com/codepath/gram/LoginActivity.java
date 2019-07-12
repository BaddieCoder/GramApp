package com.codepath.gram;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private Button loginBtn;
    private Button createBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupView();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            Toast. makeText(LoginActivity.this, "Resumed Session",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

    }

    private void setupView(){
        setContentView(R.layout.activity_login);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(6000);
        animationDrawable.setEnterFadeDuration(6000);
        animationDrawable.start();

        usernameInput = findViewById(R.id.etName);
        passwordInput = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.btnLogin);
        createBtn = findViewById(R.id.btnCreate);
    }

    private void signIn(){
            ParseUser user = new ParseUser();

        final String username = usernameInput.getText().toString();
        final String password = passwordInput.getText().toString();
            user.setUsername(username);
            user.setPassword(password);

            user.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        Log.d("SignUpActivity", "Sign up successful");
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        Toast. makeText(LoginActivity.this, "New Account Created",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    } else {
                        Log.d("SignUpActivity", "Sign up fail");
                        e.printStackTrace();
                    }
                }
            });
        }

    private void login(){
        final String username = usernameInput.getText().toString();
        final String password = passwordInput.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e == null){
                    Log.d("LoginActivity", "Login successful");
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    //we do finish so that we cant return to the login page using the back button
                }
                else{
                    Log.d("LoginActivity", "Login fail");
                    e.printStackTrace();
                }
            }
        });
    }
}
