package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hayley on 9/30/17.
 */

public class Account implements Parcelable {

    private int numAdults;
    private int numKids;
    private int numPets;

    public Account(int numAdults, int numKids, int numPets) {
        this.numAdults = numAdults;
        this.numKids = numKids;
        this.numPets = numPets;
    }

    protected Account(Parcel in) {
        numAdults = in.readInt();
        numKids = in.readInt();
        numPets = in.readInt();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(numAdults);
        parcel.writeInt(numKids);
        parcel.writeInt(numPets);
    }
}

