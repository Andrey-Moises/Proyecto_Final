package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent GO = getIntent();

        videoView = findViewById(R.id.video);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample1));
        videoView.start();

    }
}