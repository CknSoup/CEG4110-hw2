package com.example.andrewsjoberg.ceg4110homework26;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockView1 extends Activity implements ClockView{
    private Controller c;
    private TextView time;
    private TextView date;
    public ClockView1(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_view1);
        c = Controller.getInstance();
        c.registerView(this);
        date = findViewById(R.id.dateText);
        time = findViewById(R.id.timeText);
        date.setText("");
        date.setTextColor(Color.DKGRAY);
        time.setText("");
        time.setTextColor(Color.BLACK);
        Button destroyB = findViewById(R.id.destroyB);
        destroyB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.removeView(0);
                finish();
            }
        });
    }

    @Override
    public void update(Date d) {
        // date
        SimpleDateFormat dateDF = new SimpleDateFormat("MMM, dd, yyyy");
        String dateS = dateDF.format(d);
        date.setText(dateS);
        //time
        SimpleDateFormat timeDF = new SimpleDateFormat("HH:mm:ss");
        String timeS = timeDF.format(d);
        time.setText(timeS);
    }
}
