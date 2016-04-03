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
        String dateString = "Date: " + ListOfEventsActivity.getCurrentEvent().getDateString();
        date.setText(dateString);

        TextView address = (TextView) findViewById(R.id.address_textView);
        String addressString = "Address: " + ListOfEventsActivity.getCurrentEvent().getStreetAddress()
                + ", " + ListOfEventsActivity.getCurrentEvent().getZip();
        address.setText(addressString);

        TextView summary = (TextView) findViewById(R.id.summary_textView);
        summary.setText(ListOfEventsActivity.getCurrentEvent().getSummary());

        TextView contact = (TextView) findViewById(R.id.contact_textView);
        String email = ListOfEventsActivity.getCurrentEvent().getEmail();
        String contactString;
        if (email.isEmpty()) {
            contactString = "Phone: " + ListOfEventsActivity.getCurrentEvent().getPhoneNumber();
            contact.setText(contactString);
        } else {
            contactString = "Email: " + email
                    + "\nPhone: " + ListOfEventsActivity.getCurrentEvent().getPhoneNumber();
            contact.setText(contactString);
        }

        TextView numFollows = (TextView) findViewById(R.id.number_followers_textView);
        String followersString = "Number of followers: "
                + ListOfEventsActivity.getCurrentEvent().getFollowers();
        numFollows.setText(followersString);

        //click follow button
        Button followButton = (Button) findViewById(R.id.button);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePageActivity.getGlobalUser().addFollowedEvent(ListOfEventsActivity.getCurrentEvent());
                ListOfEventsActivity.getCurrentEvent().addFollower();
                Intent intent = new Intent(EventDetailsActivity.this, UserProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}
