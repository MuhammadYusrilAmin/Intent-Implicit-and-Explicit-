package com.example.impintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    // Deklarasi TextView
    TextView txtHello;
    // Membuat sebuah String dengan Access modifier private
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Mengambil TextView dari activity_second.xml Berdasarkan Id TextView
        txtHello = (TextView) findViewById(R.id.txtHello);
        // Deklarasi bundle untuk mengakses data yang sebelumnya dikirim
        Bundle extras = getIntent().getExtras();
        // kode untuk mengambil data yang sebelumnya di kirim
        nama = extras.getString(KEY_NAME);
        // kode untuk menampilkan pesan
        txtHello.setText("Hello, " + nama + " !!!");

    }
}