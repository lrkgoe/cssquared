package com.github.reachout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakeEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_event);

        Button createEventButton = (Button) findViewById(R.id.createEvent);
        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eventName = (EditText) findViewById(R.id.name_editText);
                EditText streetNumber = (EditText) findViewById(R.id.street_number_editText);
                EditText houseAddress = (EditText) findViewById(R.id.house_address_editText);
                EditText zipCode = (EditText) findViewById(R.id.zip_code_editText);
                EditText email = (EditText) findViewById(R.id.email_editText);
                EditText phoneNumber = (EditText) findViewById(R.id.phone_number_editText);
                EditText summary = (EditText) findViewById(R.id.summary_editText);
                EditText date = (EditText) findViewById(R.id.date_editText);
                EditText time = (EditText) findViewById(R.id.time_editText);
            }

        });
    }



}
