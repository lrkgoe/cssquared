package com.github.reachout;
import java.util.Comparator;
import java.util.Date;
import java.lang.Object;


/**
 * Created by Yash on 4/2/2016.
 */
public class Event implements Comparable<Date> {

    private String streetAddress;
    private String town;
    private String country;
    private int zip;
    private String summary;
    private Date date;
    private String email;
    private int phoneNumber;


    public Event(String streetAddress, String town, String country, int zip, String summary,
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

    public String getStreetAddress() {
        return streetAddress;
    }

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

    public int compareTo(Date b) {
        return this.compareTo(b);
    }

}
