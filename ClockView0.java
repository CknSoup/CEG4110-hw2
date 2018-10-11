package com.example.andrewsjoberg.ceg4110homework26;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ProgressBar;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;

public class ClockView0 extends Activity implements ClockView {
    private Controller c;
    private CalendarView cv;
    private ProgressBar tb;
    private final int SECONDS_IN_DAY = 86400;
    public ClockView0(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_view0);
        c = Controller.getInstance();
        c.registerView(this);
        cv = findViewById(R.id.calendarView);

        tb = findViewById(R.id.timeBar);
        tb.setProgress(0);
        Button destroyB = findViewById(R.id.destroyB);
        destroyB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                c.removeView(0);
                finish();
            }
        });
    }

    @Override
    public void update(Date d) {
        cv.setDate(d.getTime());

        // Set timeBar with hours, minutes, and seconds
        SimpleDateFormat hour = new SimpleDateFormat("HH");
        SimpleDateFormat minute = new SimpleDateFormat("mm");
        SimpleDateFormat second = new SimpleDateFormat("ss");
        String hourS = hour.format(d);
        String minuteS = minute.format(d);
        String secondS = second.format(d);
        int hourI = Integer.parseInt(hourS);
        int minuteI = Integer.parseInt(minuteS);
        int secondI = Integer.parseInt(secondS);
        // transform hours and minutes into seconds
        hourI *= 60;
        minuteI += hourI;
        minuteI *= 60;
        secondI += minuteI;
        // make that a percentage
        double temp = (double) secondI / SECONDS_IN_DAY;
        // make that percentage into a 2 (or 3) digit integer;
        temp *= 100;
        int timeI = (int) temp;
        tb.setProgress(timeI);
    }
}
