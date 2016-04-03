package com.github.reachout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class UserProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Button followedEvents = (Button) findViewById(R.id.followed_events_button);
        Button createdEvents = (Button) findViewById(R.id.created_events_button);
        Button eventList = (Button) findViewById(R.id.event_list_button);
        Button makeEvent = (Button) findViewById(R.id.make_new_event_button);

        followedEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfileActivity.this, SignedUpEventsActivity.class);
                startActivity(i);

            }
        });
        createdEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfileActivity.this, StartedEventsActivity.class);
                startActivity(i);

            }
        });
        eventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfileActivity.this, ListOfEventsActivity.class);
                startActivity(i);

            }
        });

        makeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserProfileActivity.this, MakeEventActivity.class);
                startActivity(i);

            }
        });
    }
}
