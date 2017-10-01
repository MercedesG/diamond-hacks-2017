package com.example.beth.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by hayley on 9/30/17.
 */

public class Item {
    private String name;
    private double price;
    private int quantity;
    private boolean expire;
    private Date expiration;

    public Item(String name) {
        this.name = name;
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
}
