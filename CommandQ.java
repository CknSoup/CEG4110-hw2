package com.example.andrewsjoberg.ceg4110homework26;

import android.util.Log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CommandQ {
    private static final CommandQ ourInstance = new CommandQ();
    private Deque<ChangeTime> u; // undo queue
    private Deque<ChangeTime> r; // redo queue

    public static CommandQ getInstance() {
        return ourInstance;
    }

    private CommandQ() {
        u = new ArrayDeque<>();
        r = new ArrayDeque<>();
    }

    public void push(ChangeTime t){
        u.add(t);
        if (!r.isEmpty()){
            r.clear();
        }
    }

    public void undo(){
        if (!u.isEmpty()) {
            ChangeTime t = u.pollLast();
            t.undoChangeTime();
            r.add(t);
        }
    }

    public void redo(){
        if (!r.isEmpty()){
            ChangeTime t = r.pollLast();
            t.changeTime();
            u.add(t);
        }
    }

    public void reset(){
        u.clear();
        r.clear();
    }
}
