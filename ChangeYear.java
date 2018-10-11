package com.example.andrewsjoberg.ceg4110homework26;

import java.util.Calendar;

public class ChangeYear implements ChangeTime {
    private ClockModel m;
    private final int i = Calendar.YEAR;
    private final boolean up;

    public ChangeYear(ClockModel m, boolean up){
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
