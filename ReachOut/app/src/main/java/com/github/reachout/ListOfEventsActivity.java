package com.github.reachout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListOfEventsActivity extends AppCompatActivity {

    private ListView eventList;
    private String[] events;
    private static Event currentEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_events);
        TextView listPageTitle = (TextView) findViewById(R.id.event_list_textView);
        listPageTitle.setText("List of events near " + HomePageActivity.getGlobalUser().getZipCode()
            + ":");

        Bundle bundle = this.getIntent().getExtras();

        events = HomePageActivity.getEventManager().toArray();

        eventList = (ListView) findViewById(R.id.event_list_listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListOfEventsActivity.this, R.layout.list_of_events_text_view, events);

        eventList.setClickable(true);

        eventList.setAdapter(adapter);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                currentEvent = HomePageActivity.getEventManager().getEventAt(position);//supposed to be event in view
                //Go to new activity with description
                Bundle bundle = new Bundle();

                Intent intent = new Intent(ListOfEventsActivity.this, EventDetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
                //Hit back to see list of events
            }

        });

    }

    public static Event getCurrentEvent() {
        return currentEvent;
    }
}
