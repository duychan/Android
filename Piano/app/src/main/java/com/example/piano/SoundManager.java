package com.example.piano;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.util.SparseIntArray;


public class SoundManager {
    private SoundPool soundPool;
    private SparseIntArray sparseIntArray = new SparseIntArray();
    private Handler handler = new Handler();
    private boolean muted = false;
    private Context context;

    private static final int MAX_STREAM = 10;
    private static final int STOP_DELAY_MILLIS = 10000;
    private static SoundManager _instance = null;

    public SoundManager(){
        soundPool = new SoundPool(MAX_STREAM, AudioManager.STREAM_MUSIC, 0);
    }
    public static SoundManager getInstance(){
        if(_instance == null){
            _instance = new SoundManager();
        }
        return _instance;
    }
    public void init(Context context){
        this.context = context;
        _instance.initStreamTypeMedia((Activity)context);
        _instance.addSound(R.raw.c3);
        _instance.addSound(R.raw.c4);
        _instance.addSound(R.raw.d3);
        _instance.addSound(R.raw.d4);
        _instance.addSound(R.raw.e3);
        _instance.addSound(R.raw.e4);
        _instance.addSound(R.raw.f3);
        _instance.addSound(R.raw.f4);
        _instance.addSound(R.raw.g3);
        _instance.addSound(R.raw.g4);
        _instance.addSound(R.raw.a3);
        _instance.addSound(R.raw.a4);
        _instance.addSound(R.raw.b3);
        _instance.addSound(R.raw.b4);
        _instance.addSound(R.raw.db3);
        _instance.addSound(R.raw.db4);
        _instance.addSound(R.raw.eb3);
        _instance.addSound(R.raw.eb4);
        _instance.addSound(R.raw.gb3);
        _instance.addSound(R.raw.gb4);
        _instance.addSound(R.raw.ab3);
        _instance.addSound(R.raw.ab4);
        _instance.addSound(R.raw.bb3);
        _instance.addSound(R.raw.bb4);

    }
    public void addSound(int id){
        sparseIntArray.put(id, soundPool.load(context, id, 1));
    }
    public void playSound(int id){
        if(muted){
            return;
        }
        boolean hasSound = sparseIntArray.indexOfKey(id) >= 0;
        if(!hasSound){
            return;
        }
        final int sound = soundPool.play(sparseIntArray.get(id), 1,
                1, 1, 0, 1f);
        scheduleSound(sound);
    }
    private void scheduleSound(final int id){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundPool.stop(id);
            }
        }, STOP_DELAY_MILLIS);
    }
    public void initStreamTypeMedia(Activity activity){
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }
    public static int getStreamMusicLevel(Activity activity){
        AudioManager audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        return audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }
    public void setMuted(boolean mute){
        this.muted = mute;
    }
}
