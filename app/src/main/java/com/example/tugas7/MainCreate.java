package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emerek,Etipe,Eharga, Ewarna;
    private String Smerek, Stipe, Sharga, Swarna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerek = (EditText) findViewById(R.id.create_merekvape);
        Etipe = (EditText) findViewById(R.id.create_tipe);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Ewarna = (EditText) findViewById(R.id.create_warna);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Smerek = String.valueOf(Emerek.getText());
                Stipe = String.valueOf(Etipe.getText());
                Sharga = String.valueOf(Eharga.getText());
                Swarna = String.valueOf(Ewarna.getText());
                if (Smerek.equals("")){
                    Emerek.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merek vape anda", Toast.LENGTH_SHORT).show();
                } else if (Etipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tipe vape anda", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga vape anda", Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")) {
                    Ewarna.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi warna vape anda", Toast.LENGTH_SHORT).show();
                }else {
                    Emerek.setText("");
                    Etipe.setText("");
                    Eharga.setText("");
                    Ewarna.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreatePenjualan (new PenjualanVape(null, Smerek, Stipe,Sharga ,Swarna));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

