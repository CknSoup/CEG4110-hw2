package com.example.andrewsjoberg.ceg4110homework26;

import android.os.Handler;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Controller{
    private ArrayList<ClockView> views = new ArrayList<>();
    private ClockModel m;
    private static final Controller _c = new Controller();
    private Controller() {
    }
    public static Controller getInstance(){
        return _c;
    }

    public void registerModel(ClockModel m) {
        this.m = m;
    }

    public void registerView(ClockView v) {
       views.add(v);
    }

    public void removeView(int i) {
        views.remove(i);
    }

    public void update(Date d) {
        for (int i = 0; i < views.size(); i++) {
            views.get(i).update(d);
        }
    }

    /*public String getTime() {
        return m.getTime();
    }*/

    public void reset(){
        m.reset();
    }
}