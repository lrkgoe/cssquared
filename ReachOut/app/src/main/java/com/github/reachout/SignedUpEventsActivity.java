package com.github.reachout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class SignedUpEventsActivity extends AppCompatActivity {

    private static Event currentEvent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_up_events);

        Bundle bundle = this.getIntent().getExtras();

        String[] events = HomePageActivity.getGlobalUser().stringifyFollowedEvents();

        ListView eventList = (ListView) findViewById(R.id.followed_events_listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(SignedUpEventsActivity.this, R.layout.started_events_text_view, events);

        eventList.setClickable(true);

        eventList.setAdapter(adapter);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                currentEvent = HomePageActivity.getGlobalUser().getEventsFollowed().get(position);//supposed to be event in view
                //Go to new activity with description
                Bundle bundle = new Bundle();

                Intent intent = new Intent(SignedUpEventsActivity.this, EventDetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
                //Hit back to see list of events
            }

        });
    }
}
