package com.ghfir.percobaan

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MathNotesActivity : AppCompatActivity() {

    private lateinit var tvNotesHistory: TextView
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_notes) // Pastikan layout ini ada

        tvNotesHistory = findViewById(R.id.tvNotesHistory)
        btnBack = findViewById(R.id.btnBack)

        // Ambil riwayat perhitungan dari Intent (jika ada)
        val history = intent.getStringArrayListExtra("calculation_history")
        if (history != null && history.isNotEmpty()) {
            tvNotesHistory.text = history.joinToString("\n") // Tampilkan setiap perhitungan di baris baru
        } else {
            tvNotesHistory.text = "Tidak ada riwayat perhitungan."
        }

        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke Activity sebelumnya
        }
    }
}