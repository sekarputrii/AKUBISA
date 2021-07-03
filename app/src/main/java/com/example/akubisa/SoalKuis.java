package com.example.akubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SoalKuis extends AppCompatActivity {
    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String [] pertanyaan_kuis = new String[] {
            "1. Siapa presiden Indonesia saat ini?",
            "2. Apa lambang negara Indonesia?",
            "3. Apa Ibukota Indonesia?",
            "4. Apa warna bendera negara Indonesia?",
            "5. Apa lagu kebangsaan negara Indonesia?"
    };
    //pilihan jawaban
    String[] pilihan_jawaban = new String[] {
            "Joko Widodo", "B.J Habibie", "Ir. Soekarno", "Susilo Bambang Yudhoyono",
            "Gajah Mada", "Garuda", "Harimau", "Elang",
            "Bali", "Bekasi", "Jakarta", "Yogyakarta",
            "Merah Putih", "Putih Merah", "Merah Kuning", "Kuning Merah",
            "Indonesia Pusaka", "Desaku", "Indonesia Merdeka", "Indonesia Raya"
    };
    //jawaban benar
    String[] jawaban_benar = new String[] {
            "Joko Widodo",
            "Garuda",
            "Jakarta",
            "Merah Putih",
            "Indonesia Raya"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soal_kuis);

        kuis = (TextView) findViewById(R.id.quiz);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            }
            else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"Jawab dengan selesai yaa", Toast.LENGTH_LONG).show();
        }
    }
}