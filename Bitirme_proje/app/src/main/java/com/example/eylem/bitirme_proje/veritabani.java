package com.example.eylem.bitirme_proje;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eylem on 10.03.2016.
 */
public class veritabani extends SQLiteOpenHelper {
    private static final String VERİTABANİ_ADİ = "kayitlar";
    private static final int SURUM = 1;

    public veritabani(Context c) {
        super(c, VERİTABANİ_ADİ, null, SURUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE kisiler(tc TEXT PRIMARY KEY , o_ad TEXT,o_soyad TEXT,v_ad TEXT,v_soyad TEXT ,adres TEXT)");
        db.execSQL("CREATE TABLE personel(tc TEXT PRIMARY KEY , p_ad TEXT,p_soyad TEXT ,adres TEXT)");
        db.execSQL("CREATE TABLE araclar(tc TEXT PRIMARY KEY , plaka1 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kisiler");
        db.execSQL("DROP TABLE IF EXISTS personel");
        db.execSQL("DROP TABLE IF EXISTS araclar");
        onCreate(db);
    }

}