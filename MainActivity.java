package com.example.andrewsjoberg.ceg4110homework26;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Controller c;
    private ClockModel m;
    private CommandQ q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = Controller.getInstance();
        q = CommandQ.getInstance();
        m = new ClockModel(c);
        c.registerModel(m);
        createDateChangerGUI();
    }

    private void createDateChangerGUI(){
        Button year0B = findViewById(R.id.year0b);
        Button year1B = findViewById(R.id.year1b);
        Button month0B = findViewById(R.id.month0b);
        Button month1B = findViewById(R.id.month1b);
        Button day0B = findViewById(R.id.day0b);
        Button day1B = findViewById(R.id.day1b);
        Button hour0B = findViewById(R.id.hour0b);
        Button hour1B = findViewById(R.id.hour1b);
        Button minute0B = findViewById(R.id.minute0b);
        Button minute1B = findViewById(R.id.minute1b);
        Button second0B = findViewById(R.id.second0b);
        Button second1B = findViewById(R.id.second1b);
        Button undoB = findViewById(R.id.undoB);
        Button redoB = findViewById(R.id.redoB);
        Button view0B = findViewById(R.id.createView0B);
        Button view1B = findViewById(R.id.createView1B);
        Button resetB = findViewById(R.id.resetB);

        year0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeYear(m, false);
                t.changeTime();
                q.push(t);
            }});
        year1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeYear(m, true);
                t.changeTime();
                q.push(t);
            }});
        month0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeMonth(m, false);
                t.changeTime();
                q.push(t);
            }});
        month1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeMonth(m, true);
                t.changeTime();
                q.push(t);
            }});
        day0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeDay(m, false);
                t.changeTime();
                q.push(t);
            }});
        day1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeDay(m, true);
                t.changeTime();
                q.push(t);
            }});
        hour0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeHour(m, false);
                t.changeTime();
                q.push(t);
            }});
        hour1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeHour(m, true);
                t.changeTime();
                q.push(t);
            }});
        minute0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeMinute(m, false);
                t.changeTime();
                q.push(t);
            }});
        minute1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeMinute(m, true);
                t.changeTime();
                q.push(t);
            }});
        second0B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeSecond(m, false);
                t.changeTime();
                q.push(t);
            }});
        second1B.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ChangeTime t = new ChangeSecond(m, true);
                t.changeTime();
                q.push(t);
            }});
        undoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.undo();
            }
        });
        redoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.redo();
            }
        });
        view0B.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), ClockView0.class);
                startActivity(i);
            }
        });
        view1B.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), ClockView1.class);
                startActivity(i);
            }
        });
        resetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.reset();
                q.reset();
            }
        });
    }
}
