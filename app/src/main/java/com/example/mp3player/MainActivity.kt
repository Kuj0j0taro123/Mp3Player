package com.example.mp3player

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.song)

        // Find buttons
        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)

        // Play button
        btnPlay.setOnClickListener {
            if (mediaPlayer?.isPlaying == false) {
                mediaPlayer?.start()
            }
        }

        // Pause button
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            }
        }

        // Stop button
        btnStop.setOnClickListener {
            if (mediaPlayer?.isPlaying == true || mediaPlayer?.isLooping == true) {
                mediaPlayer?.stop()
                // Reinitialize the MediaPlayer to restart playback
                mediaPlayer = MediaPlayer.create(this, R.raw.sotionng)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
