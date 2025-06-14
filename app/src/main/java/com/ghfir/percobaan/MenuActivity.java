package com.ghfir.percobaan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button tombolPindah;
    Button tombolKonverter;
    Button tombolData; // Ini masih dikomentari di kode asli Anda
    Button tombolKirimChatWA;
    Button tombolPeta;
    public static final String KEY_NAMA_MHS = "nama_mahasiswa";
    public static final String KEY_UMUR_MHS = "umur_mahasiswa";
    private TextView infoTampilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tombolPindah = findViewById(R.id.btn_move_activity);
        tombolPindah.setOnClickListener(this);

        tombolKonverter = findViewById(R.id.btn_move_converter);
        tombolKonverter.setOnClickListener(this);

        // tombolData masih dikomentari, saya biarkan seperti itu.
        // tombolData = findViewById(R.id.btn_move_activity_data);
        // tombolData.setOnClickListener(this);

        tombolKirimChatWA = findViewById(R.id.btn_dial_number);
        tombolKirimChatWA.setOnClickListener(this);

        tombolPeta = findViewById(R.id.btn_maps);
        tombolPeta.setOnClickListener(this);

        infoTampilan = findViewById(R.id.tv_data_received);

        String namaMahasiswaDiterima = getIntent().getStringExtra(KEY_NAMA_MHS);
        int usiaMahasiswaDiterima = getIntent().getIntExtra(KEY_UMUR_MHS, 0);

        final String teksUntukTampilan = "Info Mahasiswa: " + namaMahasiswaDiterima + ",\nNIMnya: " + usiaMahasiswaDiterima;

        // Panggil metode untuk efek mengetik
        typeWrite(infoTampilan, teksUntukTampilan, 100); // 100ms per karakter
    }

    @Override
    public void onClick(View v) {
        int idTombol = v.getId();
        if (idTombol == R.id.btn_move_activity) {
            Intent tujuanPindah = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(tujuanPindah);
        } else if (idTombol == R.id.btn_move_converter) {
            Intent mauKeKonverter = new Intent(MenuActivity.this, ConverterActivity.class);
            startActivity(mauKeKonverter);
            // Kode di bawah ini masih dikomentari di kode asli Anda, saya biarkan seperti itu.
            // } else if (idTombol == R.id.btn_move_activity_data) {
            // Intent niatBawaData = new Intent(MenuActivity.this, MoveWithDataActivity.class);
            // niatBawaData.putExtra(KEY_NAMA_MHS, "Faisal Mustaghfirullah");
            // niatBawaData.putExtra(KEY_UMUR_MHS, 22533568);
            // startActivity(niatBawaData);
        } else if (idTombol == R.id.btn_dial_number) {
            String nomorWA = "6289523558412";
            String isiPesan = "Halo Faisal!💋💋💋";
            try {
                Intent kirimWA = new Intent(Intent.ACTION_VIEW);
                kirimWA.setData(Uri.parse("whatsapp://send?phone=" + nomorWA + "&text=" + Uri.encode(isiPesan)));
                startActivity(kirimWA);
            } catch (Exception e) {
                Intent kePlayStore = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.whatsapp"));
                startActivity(kePlayStore);
            }
        } else if (idTombol == R.id.btn_maps) {
            Intent bukaPeta = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/QQsQAGUZ1m6m3xQy7"));
            startActivity(bukaPeta);
        }
    }

    /**
     * Metode utilitas untuk menambahkan efek mengetik pada TextView.
     * @param textView TextView yang akan menampilkan efek mengetik.
     * @param text String yang akan diketik.
     * @param intervalMs Jeda waktu antar karakter dalam milidetik.
     */
    private void typeWrite(final TextView textView, final String text, long intervalMs) {
        textView.setText(""); // Bersihkan teks sebelumnya

        ValueAnimator animator = ValueAnimator.ofInt(0, text.length());
        animator.setDuration(text.length() * intervalMs);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentLength = (int) animation.getAnimatedValue();
                textView.setText(text.substring(0, currentLength));
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // Opsional: Lakukan sesuatu setelah animasi selesai
                // Log.d("TypewriterEffect", "Efek mengetik selesai!");
            }
        });
        animator.start();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}