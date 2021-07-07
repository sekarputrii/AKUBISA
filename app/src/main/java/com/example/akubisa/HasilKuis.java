package com.example.akubisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilKuis extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.hasil_kuis);

        //mendefinisikan TextView hasil dan nilai dengan bantuan variable container yang sudah dideklarasikan diatas
        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : " + SoalKuis.benar + "\nJawaban Salah : " + SoalKuis.salah);
        nilai.setText("" + SoalKuis.hasil);
    }
    //Mengaktifkan button mengulang dari tampilan awal
    public void ulang(View view) {
        finish();
        //perintah untuk intent HasilKuis ke halaman SoalKuis kembali
        Intent intent = new Intent(getApplicationContext(), SoalKuis.class);
        //untuk memulai intent
        startActivity(intent);
    }
}
