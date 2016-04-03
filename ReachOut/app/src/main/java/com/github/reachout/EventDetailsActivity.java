package com.github.reachout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView name = (TextView) findViewById(R.id.name_textView);
        name.setText(ListOfEventsActivity.getCurrentEvent().getName());

        TextView date = (TextView) findViewById(R.id.date_textView);
        date.setText("Date: " + ListOfEventsActivity.getCurrentEvent().getDateString());

        TextView address = (TextView) findViewById(R.id.address_textView);
        address.setText("Address: " + ListOfEventsActivity.getCurrentEvent().getStreetAddress()
            + ", " + ListOfEventsActivity.getCurrentEvent().getZip());

        TextView summary = (TextView) findViewById(R.id.summary_textView);
        summary.setText(ListOfEventsActivity.getCurrentEvent().getSummary());

        TextView contact = (TextView) findViewById(R.id.contact_textView);
        String email = ListOfEventsActivity.getCurrentEvent().getEmail();
        if (email.isEmpty()) {
            contact.setText("Phone: " + ListOfEventsActivity.getCurrentEvent().getPhoneNumber());
        } else {
            contact.setText("Email: " + email
                    + "\nPhone: " + ListOfEventsActivity.getCurrentEvent().getPhoneNumber());
        }

        TextView numFollows = (TextView) findViewById(R.id.number_followers_textView);
        numFollows.setText("Number of followers: "
                + ListOfEventsActivity.getCurrentEvent().getFollowers());

        //click follow button
        Button followButton = (Button) findViewById(R.id.use_as_guest_button);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePageActivity.getGlobalUser().addFollowedEvent(ListOfEventsActivity.getCurrentEvent());
                ListOfEventsActivity.getCurrentEvent().addFollower();
                Intent intent = new Intent(EventDetailsActivity.this, ListOfEventsActivity.class);
                startActivity(intent);
            }
        });

    }
}
