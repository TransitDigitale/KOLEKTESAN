package com.kolektesan.julio.kolektesan.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

import com.kolektesan.julio.kolektesan.R;
import com.kolektesan.julio.kolektesan.model.Pub;

public class PlayerVideos extends AppCompatActivity {
    Pub pub;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_videos);

        VideoView videoPlay = (VideoView)findViewById(R.id.videoPlay);
        videoPlay.requestFocus();
        videoPlay.setMediaController(new MediaController(this));
        videoPlay.start();
        pub = (Pub) getIntent().getSerializableExtra("playpub");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        int res = pub.getAudioLink();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),res);
        mediaPlayer.start();

    }
}
