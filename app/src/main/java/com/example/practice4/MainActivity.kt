package com.example.practice4

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val video = findViewById<VideoView>(R.id.videoView)
        val mediacontrol = MediaController(this)
        mediacontrol.setAnchorView(video)
        val link: Uri = parse("android.resource://" + packageName + "/" + R.raw.video)
        video.setMediaController(mediacontrol)
        //video.setOnPreparedListener { mp -> mp.setVolume(0f, 0f) } // use to mute video
        video.setVideoURI(link)
        video.requestFocus()
        video.start()
    }
}