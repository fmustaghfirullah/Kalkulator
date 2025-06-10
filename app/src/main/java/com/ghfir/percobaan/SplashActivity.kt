package com.ghfir.percobaan

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val videoView: VideoView = findViewById(R.id.video_view)
        val videoPath = Uri.parse("android.resource://" + packageName + "/" + R.raw.faisal_splash)

        videoView.setVideoURI(videoPath)

        videoView.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                val intent = Intent(this@SplashActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        videoView.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                mp?.isLooping = false
                videoView.start()
            }
        })

        videoView.setOnErrorListener(object : MediaPlayer.OnErrorListener {
            override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
                val intent = Intent(this@SplashActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
        })
    }
}