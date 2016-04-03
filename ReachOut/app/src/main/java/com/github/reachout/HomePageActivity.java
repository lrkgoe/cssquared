package com.github.reachout;

import android.content.Intent;
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
    private static User globalUser;
    private View focusView;
    private static UserManager userList;
    private static EventManager eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //create a UserManager for the app
        userList = new UserManager();
        userList.add(new User("4@", "p", 90867));
        userList.add(new User("3@", "p", 90867));
        userList.add(new User("2@", "p", 90867));
        userList.add(new User("1@", "p", 90867));
        userList.add(new User("0@", "p", 90867));

        eventList = new EventManager();
        eventList.add(new Event("hjsbd", "askjnbda", 75857, "jhsbdk", 12, 12, 1987, "ihsbfb", 67563456));
        eventList.add(new Event("hjsbd", "askjnbda", 75857, "jhsbdk", 12, 12, 1987, "ihsbfb", 67563456));
        eventList.add(new Event("hjsbd", "askjnbda", 75857, "jhsbdk", 12, 12, 1987, "ihsbfb", 67563456));
        eventList.add(new Event("hjsbd", "askjnbda", 75857, "jhsbdk", 12, 12, 1987, "ihsbfb", 67563456));

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
                globalUser = new User(email, password, 0);
                attemptLogin();
            }
        });

        //click register button
        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get username from text field
                emailView = (EditText)findViewById(R.id.email_editText);
                email = emailView.getText().toString();

                //get password from text field
                passwordView = (EditText) findViewById(R.id.password_editText);
                password = passwordView.getText().toString();
                globalUser = new User(email, password, 0);
                attemptRegister();
            }
        });

        //click guest button
        Button guestButton = (Button) findViewById(R.id.use_as_guest_button);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalUser = new User(null, null, 0);
                Intent i = new Intent(HomePageActivity.this, ListOfEventsActivity.class);
                startActivity(i);

            }
        });


    }

    /**
     * Makes sure user enters info for both fields
     */
    private boolean aFieldIsEmpty() {
        //reset errors
        emailView.setError(null);
        passwordView.setError(null);

        focusView = null;
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
            focusView = passwordView;
            cancel = true;
        }
        return cancel;
    }

    /**
     * Attempts to log in with given credentials.
     * must make sure both email and password are valid
     */
    private void attemptLogin() {
        if (aFieldIsEmpty()) {
            //don't proceed
            focusView.requestFocus();
        } else if (!userList.contains(globalUser)) {
            //don't proceed, user does not exist
            emailView.setError("Invalid email and/or password entered.");
            focusView = emailView;
            focusView.requestFocus();
        } else {
            globalUser = userList.getUser(email);
            Intent i = new Intent(HomePageActivity.this, UserProfileActivity.class);
            startActivity(i);
        }
    }

    /**
     * Attempts to register "new" user
     * must make sure email is not already in use
     */
    private void attemptRegister() {
        if (aFieldIsEmpty()) {
            //don't proceed
            focusView.requestFocus();
        } else if (userList.contains(globalUser)) {
            //don't proceed, user already exists
            emailView.setError("This email is already registered to a user.");
            focusView = emailView;
            focusView.requestFocus();
        } else if (!isValidEmail(email)) {
            //invalid email, don't proceed
            emailView.setError("This email is invalid.");
            focusView = emailView;
            focusView.requestFocus();
        } else {
            userList.add(globalUser);
            Intent i = new Intent(HomePageActivity.this, UserProfileActivity.class);
            startActivity(i);
        }
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static UserManager getUserManager() {
        return userList;
    }

    public static User getGlobalUser() {
        return globalUser;
    }

    public static EventManager getEventManager() {
        return eventList;
    }
}
