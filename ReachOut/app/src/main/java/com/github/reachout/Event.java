package com.github.reachout;
import java.util.Comparator;
import java.util.Date;
import java.lang.Object;


/**
 * Created by Yash on 4/2/2016.
 */
public class Event implements Comparable<Event> {

    private String name;
    private String streetAddress;
    private String town;
    private String country;
    private int zip;
    private String summary;
    private Date date;
    private String email;
    private int phoneNumber;


    public Event(String name, String streetAddress, String town, String country, int zip, String summary,
                 Date date, String email, int phoneNumber) {
        this.streetAddress = streetAddress;
        this.town = town;
        this.country = country;
        this.zip = zip;
        this.summary = summary;
        this.date = date;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }

    public String getStreetAddress() { return streetAddress; }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }

    public int getZip() {
        return zip;
    }

    public String getSummary() {
        return summary;
    }

    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) { this.name = name; }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDate(Date date) {
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