package com.github.reachout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomePageActivity extends AppCompatActivity {

    private EditText emailView;
    private EditText passwordView;
    private String email;
    private String password;
    private User dummyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //click sign in button
        Button loginButton = (Button) findViewById(R.id.sign_in_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username from text field
                emailView = (EditText) findViewById(R.id.email_editText);
                email = emailView.getText().toString();

                //get password from text field
                passwordView = (EditText) findViewById(R.id.password_editText);
                password = passwordView.getText().toString();
                User dummyUser = new User(email, password, 0);
                attemptLogin(dummyUser);
            }
        });

        //click sign in button
        Button registerButton = (Button) findViewById(R.id.register_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username from text field
                emailView = (EditText)findViewById(R.id.email_editText);
                email = emailView.getText().toString();

                //get password from text field
                passwordView = (EditText) findViewById(R.id.password_editText);
                password = passwordView.getText().toString();
                dummyUser = new User(email, password, 0);
                attemptRegister();
            }
        });


    }

    /**
     * Attempts to log in with given credentials.
     * must make sure both email and password are valid
     */
    private void attemptLogin(User user) {
        //reset errors
        emailView.setError(null);
        passwordView.setError(null);

        View focusView = null;
        boolean cancel = false;

        //check to see if user entered a pass
        if (TextUtils.isEmpty(password)) {
            passwordView.setError("Enter a password.");
            focusView = passwordView;
            cancel = true;
        }
        //check to see if user entered an email
        if (TextUtils.isEmpty(email)) {
            emailView.setError("Enter an email address.");
        }

        //check to see if user exists


    }

    /**
     * Attempts to register "new" user
     * must make sure email is not already in use
     */
    private void attemptRegister() {

    }
}
