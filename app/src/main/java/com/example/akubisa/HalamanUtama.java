package com.example.akubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanUtama extends AppCompatActivity {
    Button Mulai, Keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_utama);

        Mulai = findViewById(R.id.btnmulai);
        Keluar = findViewById(R.id.btnkeluar);

        Mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HalamanUtama.this, SoalKuis.class);
                startActivity(intent);
            }
        });

        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}