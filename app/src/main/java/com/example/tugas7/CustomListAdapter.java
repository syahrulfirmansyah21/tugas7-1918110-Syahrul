package com.example.tugas7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PenjualanVape> movieItems;
    public CustomListAdapter(Activity activity, List<PenjualanVape> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView text_merek = (TextView)
                convertView.findViewById(R.id.text_merek);
        TextView text_tipe = (TextView)
                convertView.findViewById(R.id.text_tipe);
        TextView text_harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        TextView text_warna = (TextView)
                convertView.findViewById(R.id.text_warna);
        PenjualanVape m = movieItems.get(position);
        text_merek.setText("Merek : "+ m.get_merek());
        text_tipe.setText("Tipe : "+ m.get_tipe());
        text_harga.setText("Harga : "+ m.get_harga());
        text_warna.setText("Warna : "+ m.get_warna());
        return convertView;
    }
}

