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
    //inisialiasi TextView, RadioGroup, dan RadioButton
    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    //type data dari method
    int nomor = 0;
    //method agar bisa dilihat oleh semua class tanpa melakukan instansi pada class tersebut
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

        //pendefinisan TextView, RadioGroup, dan RadioButton
        kuis = (TextView) findViewById(R.id.quiz);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        //untuk menampilkan text yang diambil kedalam text area dibawahnya
        //digunakan juga untukk memunculkan text pada variabel
        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    //method next
    public void next(View view) {
        //kondisi option jawaban yang ingin dipilih
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            //kondisi untuk memilih jawaban benar dari user ditambah perulangan
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            //kondisi lain jika jawaban salah
            else salah++;
            //perulangan
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            }
            //kondisi jika jawaban benar
            else {
                //jawaban yang benar akan dikali 20 per soal
                hasil = benar * 20;
                //Perintah untuk intent halaman soalKuis ke HasilKuis
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        //kondisi lain jika tidak memilih option jawaban dan langsung melanjutkan ke soal berikutnya
        else {
            Toast.makeText(this,"Jawab dengan selesai yaa", Toast.LENGTH_LONG).show();
        }
    }
}