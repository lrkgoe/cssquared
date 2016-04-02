package com.github.reachout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
                EditText houseAddress = (EditText) findViewById(R.id.house_address_editText);
                EditText zipCode = (EditText) findViewById(R.id.zip_code_editText);
                EditText email = (EditText) findViewById(R.id.email_editText);
                EditText phoneNumber = (EditText) findViewById(R.id.phone_number_editText);
                EditText summary = (EditText) findViewById(R.id.summary_editText);
                EditText date = (EditText) findViewById(R.id.date_editText);
                EditText month = (EditText) findViewById(R.id.month_editText);
                EditText year = (EditText) findViewById(R.id.year_editText);
                String name = eventName.getText().toString();
                String streetNo = houseAddress.getText().toString();
                int zip = Integer.parseInt(zipCode.getText().toString());
                String emailAddress = email.getText().toString();
                int phone = Integer.parseInt(phoneNumber.getText().toString());
                String eventSummary = summary.getText().toString();
                int dateNo = Integer.parseInt(date.getText().toString());
                int monthNo = Integer.parseInt(month.getText().toString());
                int yearNo = Integer.parseInt(year.getText().toString());
                Calendar fullDate = new GregorianCalendar(yearNo, monthNo, dateNo);
                Event newEvent = new Event(name, streetNo, zip, eventSummary, fullDate, emailAddress, phone);
                User current = HomePageActivity.getGlobalUser();
                current.addNewEvent(newEvent);
                EventManager manage = HomePageActivity.getEventManager();
                manage.add(newEvent);

            }

        });
    }



}
