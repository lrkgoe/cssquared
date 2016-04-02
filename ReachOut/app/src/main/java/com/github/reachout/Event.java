package com.github.reachout;
import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Created by Yash on 4/2/2016.
 */
public class Event implements Comparable<Event> {

    private String name;
    private String streetAddress;
    private int zip;
    private String summary;
    private Calendar date;
    private String email;
    private int phoneNumber;


    public Event(String name, String streetAddress, int zip, String summary, Calendar date,
                 String email, int phoneNumber) {
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.summary = summary;
        this.date = date;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }

    public String getStreetAddress() { return streetAddress; }

    public int getZip() {
        return zip;
    }

    public String getSummary() {
        return summary;
    }

    public Calendar getDate() {

        return date;
    }

    public String getDateString() {
        int month = this.getDate().get(Calendar.MONTH);
        int day = this.getDate().get(Calendar.DAY_OF_MONTH);
        int year = this.getDate().get(Calendar.YEAR);
        return month + "/" + day + "/" + year;

    }

    public String getEmail() { return email; }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) { this.name = name; }

    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int compareTo(Event b) {
        return this.getDate().compareTo(b.getDate());
    }

}
