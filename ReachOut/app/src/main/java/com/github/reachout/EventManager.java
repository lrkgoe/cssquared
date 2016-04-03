package com.github.reachout;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Yash on 4/2/2016.
 */
public class EventManager {
    private static ArrayList<Event> eventList;

    public EventManager() {
        eventList = new ArrayList<Event>();
    }

    public void add(Event event) {
        eventList.add(event);
        Collections.sort(eventList);
    }

    public ArrayList<Event> get() {
        return eventList;
    }

    public void remove(Event event) {
        eventList.remove(event);
    }

    public String[] toArray() {
        String[] eventArr = new String[eventList.size()];
        for (int i = 0; i < eventList.size(); i++) {
            eventArr[i] = eventList.get(i).getName() + "\n\tDate: " + eventList.get(i).getDate();
        }
        return eventArr;
    }

    public Event getEventAt(int index) {
        return eventList.get(index);
    }
}
