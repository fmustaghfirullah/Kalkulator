package com.ghfir.percobaan // Sesuaikan dengan package name-mu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH: Long = 3000 // Durasi total splash screen terlihat (termasuk animasi)

    override fun onCreate(savedInstanceState: Bundle?) {
        // Panggil installSplashScreen() SEBELUM super.onCreate()
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Kamu mungkin tidak perlu setContentView jika activity ini hanya untuk splash
        // dan langsung pindah, karena tema yang mengatur tampilannya.
        // Jika kamu set layout di sini, pastikan itu tidak menimpa animasi splash.
        // setContentView(R.layout.activity_splash)


        // (Opsional) Jika kamu perlu menunggu task lain sebelum pindah
        // splashScreen.setKeepOnScreenCondition { /* kondisi loadingmu */ true }


        // Pindah ke MenuActivity setelah durasi tertentu
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}