package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smerek, Stipe ,Sharga, Swarna;
    private EditText Emerek, Etipe ,Eharga, Ewarna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerek = i.getStringExtra("Imerek");
        Stipe = i.getStringExtra("Itipe");
        Sharga = i.getStringExtra("Iharga");
        Swarna = i.getStringExtra("Iwarna");
        Emerek = (EditText) findViewById(R.id.updel_merekvape);
        Etipe = (EditText) findViewById(R.id.updel_tipe);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Ewarna= (EditText) findViewById(R.id.updel_warna);
        Emerek.setText(Smerek);
        Etipe.setText(Stipe);
        Eharga.setText(Sharga);
        Ewarna.setText(Swarna);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerek= String.valueOf(Emerek.getText());
                Stipe= String.valueOf(Etipe.getText());
                Sharga = String.valueOf(Eharga.getText());
                Swarna = String.valueOf(Ewarna.getText());
                if (Smerek.equals("")){
                    Emerek.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merek vape", Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")) {
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tipe vape", Toast.LENGTH_SHORT).show();
                }  else if (Sharga.equals("")){
                        Eharga.requestFocus();
                        Toast.makeText(MainUpdel.this, "Silahkan isi harga vape", Toast.LENGTH_SHORT).show();
                } else if (Swarna.equals("")){
                    Ewarna.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi warna vape",
                            Toast.LENGTH_SHORT).show();
                } else {db.UpdatePenjualanVape(new PenjualanVape(Sid, Smerek, Stipe ,Sharga, Swarna));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePenjualanLaptpop (new PenjualanVape(Sid, Smerek,Stipe, Sharga, Swarna));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

