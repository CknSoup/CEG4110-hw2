package com.example.andrewsjoberg.ceg4110homework26;

import java.util.Calendar;

public class ChangeMonth implements ChangeTime {
    private ClockModel m;
    private final int i = Calendar.MONTH;
    private final boolean up;

    public ChangeMonth(ClockModel m, boolean up){
        this.m = m;
        this.up = up;
    }

    @Override
    public void changeTime() {
        m.changeTime(i, up);
    }

    @Override
    public void undoChangeTime() {
        m.changeTime(i, !up);
    }
}
