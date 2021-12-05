package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<PenjualanVape> ListPenjualanVape = new ArrayList<PenjualanVape>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this,ListPenjualanVape);
        mListView = (ListView) findViewById(R.id.list_penjualan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPenjualanVape.clear();
        List<PenjualanVape> contacts = db.ReadPenjualanLaptop();
        for (PenjualanVape cn : contacts) {
            PenjualanVape judulModel = new PenjualanVape();
            judulModel.set_id(cn.get_id());
            judulModel.set_merek(cn.get_merek());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.setharga(cn.get_harga());
            judulModel.set_warna(cn.get_warna());
            ListPenjualanVape.add(judulModel);
            if ((ListPenjualanVape.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        PenjualanVape obj_itemDetails = (PenjualanVape) o;
        String Sid = obj_itemDetails.get_id();
        String Smerek = obj_itemDetails.get_merek();
        String Stipe = obj_itemDetails.get_tipe();
        String Sharga = obj_itemDetails.get_merek();
        String Swarna = obj_itemDetails.get_warna();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imerek", Smerek);
        goUpdel.putExtra("Itipe", Stipe);
        goUpdel.putExtra("Iharga", Sharga);
        goUpdel.putExtra("Iwarna", Swarna);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPenjualanVape.clear();
        mListView.setAdapter(adapter_off);
        List<PenjualanVape> contacts = db.ReadPenjualanLaptop();
        for (PenjualanVape cn : contacts) {
            PenjualanVape judulModel = new PenjualanVape();
            judulModel.set_id(cn.get_id());
            judulModel.set_merek(cn.get_merek());
            judulModel.set_tipe(cn.get_tipe());
            judulModel.setharga(cn.get_harga());
            judulModel.set_warna(cn.get_warna());
            ListPenjualanVape.add(judulModel);
            if ((ListPenjualanVape.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

