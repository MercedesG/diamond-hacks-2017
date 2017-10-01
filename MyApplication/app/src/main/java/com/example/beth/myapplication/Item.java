package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by hayley on 9/30/17.
 */

public class Item implements Parcelable {
    private String name;
    private double price;
    private int quantity;
    private boolean expire;
    private Date expiration;

    public Item(String name) {
        this.name = name;
    }

    protected Item(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
        expire = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean canExpire() {
        return expire;
    }
    public void setExpire(boolean expire) {
        this.expire = expire;
    }
    public Date getExpiration() {
        return this.expiration;
    }
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(price);
        parcel.writeInt(quantity);
        parcel.writeByte((byte) (expire ? 1 : 0));
    }
}
