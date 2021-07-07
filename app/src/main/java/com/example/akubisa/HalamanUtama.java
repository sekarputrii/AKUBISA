package com.example.akubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanUtama extends AppCompatActivity {
    //inisialisasi button
    Button Mulai, Keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_utama);

        //Pendefinisian button mulai dan keluar
        Mulai = findViewById(R.id.btnmulai);
        Keluar = findViewById(R.id.btnkeluar);

        Mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Perintah untuk Intent Explicit HalamanUtama ke SoalKuis
                //Intent Explicit berfungsi melakukan perpindahan activity menuju ke activity lainnya
                Intent intent = new Intent(HalamanUtama.this, SoalKuis.class);
                //Menjalankan perintah Intent Explicit
                startActivity(intent);
            }
        });

        //Untuk mengaktifkan button keluar
        Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            //System.exit(0) digunakan untuk menunjukkan pemutusan hubungan kerja yang sukses
            //sehingga hanya bisa menutup activity yang sedang aktif
            //force close
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}