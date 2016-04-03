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
    private Calendar fullDate;
    private String email;
    private long phoneNumber;



    private int date;
    private int month;
    private int year;
    private int followers;

    public Event(String name, String streetAddress, int zip, String summary, int date, int month,
                 int year, String email, long phoneNumber) {
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.summary = summary;
        this.date = date;
        this.month = month;
        this.year = year;
        this.fullDate = new GregorianCalendar(date, month, year);
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

        return fullDate;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDateString() {
                return month + "/" + date + "/" + year;

    }

    public String getEmail() { return email; }

    public long getPhoneNumber() {
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
        this.fullDate = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFollowers() {
        return followers;
    }

    public void addFollower() {
        followers++;
    }

    public int compareTo(Event b) {
        return this.getDate().compareTo(b.getDate());
    }

}
