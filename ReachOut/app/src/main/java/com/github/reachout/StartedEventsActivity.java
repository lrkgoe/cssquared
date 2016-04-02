package com.github.reachout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartedEventsActivity extends AppCompatActivity {
    private ListView eventList;
    private String[] events;
    private static Event currentEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_events);

        Bundle bundle = this.getIntent().getExtras();

        events = HomePageActivity.getGlobalUser().stringifyCreatedEvents();

        eventList = (ListView) findViewById(R.id.created_events_listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(StartedEventsActivity.this, R.layout.activity_started_events, events);

        eventList.setClickable(true);

        eventList.setAdapter(adapter);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                currentEvent = HomePageActivity.getGlobalUser().getEventsCreated().get(position);//Go to new activity with description
                Bundle bundle = new Bundle();

                Intent intent = new Intent(StartedEventsActivity.this, EventDetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
                //Hit back to see list of events
            }

        });
    }
}
