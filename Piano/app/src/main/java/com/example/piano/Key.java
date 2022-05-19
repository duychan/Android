package com.example.piano;

import android.graphics.RectF;

public class Key {
    private int sound;
    private RectF rect;
    private boolean down;

    public int getSound() {
        return this.sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public RectF getRect() {
        return this.rect;
    }

    public void setRect(RectF rect) {
        this.rect = rect;
    }

    public void setDown(boolean down){
        this.down = down;
    }

    public boolean getDown(){
        return this.down;
    }
    public Key(int sound, RectF rect) {
        this.sound = sound;
        this.rect = rect;
    }
}
