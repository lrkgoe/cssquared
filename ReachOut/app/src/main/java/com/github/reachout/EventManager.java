package com.github.reachout;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yash on 4/2/2016.
 */
public class EventManager {
    private static ArrayList<Event> eventList;

    public EventManager() {

    }

    public void add(Event event) {
        eventList.add(event);
        Collections.sort(eventList);
    }

    public void remove(Event event) {
        eventList.remove(event);
    }
}
