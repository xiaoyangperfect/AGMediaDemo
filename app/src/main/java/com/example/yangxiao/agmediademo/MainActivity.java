package com.example.yangxiao.agmediademo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RemoteControlReceiver mRemoteControlReceiver;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set volume at create
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int i) {

            }
        };

        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int requestResult = audioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        if (requestResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//            audioManager.registerMediaButtonEventReceiver();
        }
    }
}
