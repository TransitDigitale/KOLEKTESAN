package com.kolektesan.julio.kolektesan.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Pub;

public class PlayerMusic extends AppCompatActivity {
    Pub pub;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pub = (Pub) getIntent().getSerializableExtra("playpub");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        int res = pub.getAudioLink();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),res);
        mediaPlayer.start();

        /*
        String uri="http://cristalhotelhaiti.com/music/baysan.mp3";
        Uri myUri = Uri.parse(uri); // initialize Uri here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            // or just mediaPlayer.setDataSource(mFileName);
            mediaPlayer.prepare(); // must call prepare first
            mediaPlayer.start(); // then start
            o
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 mediaPlayer.pause();
            }
        });
    }
}
