package com.example.andrewsjoberg.ceg4110homework26;

import android.app.Activity;
import android.widget.Button;

import java.io.Serializable;
import java.security.acl.Acl;
import java.util.Date;

public interface ClockView{
    // private Controller c;
    // In constructor: c.registerView(this);

    public void update(Date d);

}
