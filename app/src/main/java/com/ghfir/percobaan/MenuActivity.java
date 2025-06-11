package com.ghfir.percobaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
Button btnMoveActivity;
Button btnMoveConverter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);
    btnMoveActivity = findViewById(R.id.btn_move_activity);
    btnMoveActivity.setOnClickListener(this);
    btnMoveConverter = findViewById(R.id.btn_move_converter);
    btnMoveConverter.setOnClickListener(this);
    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_move_activity:
//                Intent moveIntent = new Intent(MenuActivity.this, MainActivity.class);
//                startActivity(moveIntent);
//                break;
//        }
//    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_move_activity) {
            Intent moveIntent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(moveIntent);
        }
        // Add more else if blocks here for other views if needed
         else if (id == R.id.btn_move_converter) {
        //    // Do something else
        Intent moveConverter = new Intent(MenuActivity.this, ConverterActivity.class);
        startActivity(moveConverter);
         }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}