package com.example.impintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Deklarasi Button
    Button button, btnSend;
    // Deklarasi botton
    EditText editText, name;
    // Membuat sebuah String dengan Access modifier private
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mengambil editText dari activity_main.xml Berdasarkan Id editText
        editText = findViewById(R.id.editText);
        name = findViewById(R.id.edit_nama);
        //Mengambil Button dari activity_main.xml Berdasarkan Id Button
        btnSend = findViewById(R.id.btn_send);
        button = findViewById(R.id.button);

        // Aksi yang akan di jalankan jika botton di klik
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // mengambil data di editText dan dikonversi ke String
                String url=editText.getText().toString();
                // kode untuk berpindah halaman
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });

        // Aksi yang akan di jalankan jika btnSend di klik
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // mengambil data di editText dan dikonversi ke String
                    String nama = name.getText().toString();
                    // Kode kondisi untuk mengecek data di nama bernilai null atau tidak
                    if (nama != ""){
                        // kode untuk berpindah halaman
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        // kode untuk menandai data mana yang akan diambil dan Value adalah data yang akan dikirim.
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        // kode untuk menampilkan pesan jika data nama bernilai null
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                    // kode untuk menampilkan pesan jika terdapat error
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN!",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}