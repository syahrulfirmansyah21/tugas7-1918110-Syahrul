package com.example.tugas7;

public class PenjualanVape {
    private String _id, _merek, _tipe, _harga,_warna;
    public PenjualanVape (String id, String merek, String tipe, String harga, String warna) {
        this._id = id;
        this._merek = merek;
        this._tipe = tipe;
        this._harga = harga;
        this._warna = warna;
    }
    public PenjualanVape() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merek() {
        return _merek;
    }
    public void set_merek(String _merek) {
        this._merek = _merek;
    }
    public String get_tipe() {
        return _tipe;
    }
    public void set_tipe(String _tipe) {
        this._tipe = _tipe;
    }
    public String get_harga() {
        return _harga;
    }
    public void setharga(String harga) {
        this._harga = _harga;
    }
    public String get_warna() {
        return _warna;
    }
    public void set_warna(String _warna) {
        this._warna = _warna;
    }
}

