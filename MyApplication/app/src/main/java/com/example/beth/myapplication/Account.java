package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hayley on 9/30/17.
 */

public class Account {

    public String listName;
    public int numAdults;
    public int numKids;
    public int numPets;

    public Account(String listName, int numAdults, int numKids, int numPets) {
        this.listName = listName;
        this.numAdults = numAdults;
        this.numKids = numKids;
        this.numPets = numPets;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getNumAdult() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumKids() {
        return numKids;
    }

    public void setNumKids(int numKids) {
        this.numKids = numKids;
    }

    public int getNumPets() {
        return numPets;
    }

    public void setNumPets(int numPets) {
        this.numPets = numPets;
    }
}

