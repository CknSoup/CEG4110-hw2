package com.example.andrewsjoberg.ceg4110homework26;

import android.os.Handler;
import android.util.Log;

import java.io.Serializable;
import java.util.Calendar;

public class ClockModel{
    private Calendar date;
    private String theTime;
    private Controller c;
    public ClockModel(Controller c){
        this.c = c;
        reset();
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
                        sleep(1000);
                        updateTime();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }


    public void updateTime(){
        date.add(Calendar.SECOND, 1);
        theTime = date.getTime().toString();
        c.update(date.getTime());
        Log.i("Time is", String.valueOf(date.getTime()));
    }

    public void reset(){
        date = Calendar.getInstance();
    }

    /**
     *
     * @param i Interval: An integer value corresponding to time
     *          interval type (Year, minute, etc.) to be applied to.
     * @param up A boolean determining whether the time should advance
     *           'up' (or 'down').
     */
    public void changeTime(int i, boolean up){
        date.roll(i, up);
    }

    /*public String getTime(){
        return theTime;
    }*/
}