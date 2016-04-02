package com.github.reachout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;

/**
 * Created by Yash on 4/2/2016.
 */
public class EventCalendar {
    private ArrayList<Event> eventList;

    public EventCalendar() {
    }

    public void add(Event event) {
        eventList.add(event);
        Collections.sort(eventList);
    }

    public void remove(Event event) {
        eventList.remove(event);
    }

    public void update(Event event, Calendar newDate) {
        int eventIndex = eventList.indexOf(event);
        eventList.get(eventIndex).setDate(newDate);
    }

}
