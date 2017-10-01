package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by hayley on 9/30/17.
 */

public class Item {
    public String name;
    public double price;
    public int quantity;
    public int expire;
    public String expiration;

    public Item(String name, double price, int quantity, int expire, String expiration) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expire = expire;
        this.expiration = expiration;
    }

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
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getExpiration() {
        return this.expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
