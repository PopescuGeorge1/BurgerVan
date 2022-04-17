package com.example.burgervan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class bundleForDatabase {
    private String loc, nr, total_toPay;;
    private ArrayList<itemObj>items;


    public bundleForDatabase(String loc, String nr,String total_toPay, ArrayList<itemObj>items){
    this.loc=loc;
    this.nr=nr;
    this.items=items;
    this.total_toPay=total_toPay;
}

    public String getTotal_toPay() {
        return total_toPay;
    }

    public String getLoc() {
        return loc;
    }

    public String getNr() {
        return nr;
    }

    public ArrayList<itemObj> getItems() {
        return items;
    }


}