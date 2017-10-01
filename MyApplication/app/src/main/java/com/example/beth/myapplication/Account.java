package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hayley on 9/30/17.
 */

public class Account {

    private int numAdults;
    private int numKids;
    private int numPets;

    public Account(int numAdults, int numKids, int numPets) {
        this.numAdults = numAdults;
        this.numKids = numKids;
        this.numPets = numPets;
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

