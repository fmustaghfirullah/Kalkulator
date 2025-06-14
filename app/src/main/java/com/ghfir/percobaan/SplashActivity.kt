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

        val pemutarVideo: VideoView = findViewById(R.id.video_view)
        val sumberVideo = Uri.parse("android.resource://" + packageName + "/" + R.raw.faisal_splash)

        pemutarVideo.setVideoURI(sumberVideo)

        pemutarVideo.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer?) {
                val mauPindah = Intent(this@SplashActivity, MenuActivity::class.java)
                mauPindah.putExtra(MenuActivity.KEY_NAMA_MHS, "Faisal Mustaghfirullah")
                mauPindah.putExtra(MenuActivity.KEY_UMUR_MHS, 22533568)
                startActivity(mauPindah)
                finish()
            }
        })

        pemutarVideo.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                mp?.isLooping = false
                pemutarVideo.start()
            }
        })

        pemutarVideo.setOnErrorListener(object : MediaPlayer.OnErrorListener {
            override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
                val mauPindahCepat = Intent(this@SplashActivity, MenuActivity::class.java)
                mauPindahCepat.putExtra(MenuActivity.KEY_NAMA_MHS, "Faisal Mustaghfirullah")
                mauPindahCepat.putExtra(MenuActivity.KEY_UMUR_MHS, 22533568)
                startActivity(mauPindahCepat)
                finish()
                return true
            }
        })
    }
}