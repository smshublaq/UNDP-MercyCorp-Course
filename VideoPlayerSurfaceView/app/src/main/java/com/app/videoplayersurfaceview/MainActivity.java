package com.app.videoplayersurfaceview;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SurfaceView surfaceView = findViewById(R.id.surfaceView);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d("aaa","Aaa");

        final MediaPlayer player = new MediaPlayer();
        
        try {
            player.setDataSource("http://techslides.com/demos/sample-videos/small.mp4");
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    player.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
