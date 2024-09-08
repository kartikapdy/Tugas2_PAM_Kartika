package com.example.tugaz2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Mengambil hasil perhitungan dari MainActivity
        TextView tvResult = findViewById(R.id.tvResult);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);
        String nim = intent.getStringExtra("nim");
        String name = intent.getStringExtra("name");

        // Tampilkan hasil perhitungan, nim, dan nama
        tvResult.setText("Hasil: " + result + "\nNIM: " + nim + "\nNama: " + name);

        // Tombol untuk kembali ke MainActivity
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke MainActivity
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                // Atau bisa pakai finish() jika ingin menutup ResultActivity
                finish();
            }
        });
    }
}