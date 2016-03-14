package com.example.eylem.bitirme_proje;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class personel extends AppCompatActivity {
    EditText tc,p_ad,p_soyad,adres;
    TextView tcno,adi,soyadi,tw,p_adres;
    Button kaydet,kisiara,sil,güncelle;
    veritabani v2;
    // private static final String TABLE_NAME = "musteri_listesi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personel);



        v2 = new veritabani(this);
        tc = (EditText) findViewById(R.id.tc);
        p_ad = (EditText) findViewById(R.id.p_ad);
        p_soyad = (EditText) findViewById(R.id.p_soyad);
        adres = (EditText) findViewById(R.id.adres);

        tcno = (TextView) findViewById(R.id.p1);
        adi = (TextView) findViewById(R.id.p2);
        soyadi = (TextView) findViewById(R.id.p3);
        p_adres = (TextView) findViewById(R.id.p4);

        kaydet = (Button) findViewById(R.id.btn_kaydet);
        kisiara = (Button) findViewById(R.id.btn_ara);
        sil = (Button) findViewById(R.id.btn_sil);
        güncelle = (Button) findViewById(R.id.btn_güncelle);
        tw = (TextView) findViewById(R.id.tw);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Kayitekle(tc.getText().toString(), p_ad.getText().toString(), p_soyad.getText().toString(), adres.getText().toString());
                    // Cursor cursor = KayitGetir();KayitGoster(cursor);

                } finally {
                    v2.close();
                }
            }
        });
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kayitsil(tc.getText().toString());
                // Cursor cursor = KayitGetir();KayitGoster(cursor);
            }
        });
    }
    private void Kayitekle(String tc,String p_ad,String p_soyad,String adres) {
        SQLiteDatabase db = v2.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("tc", tc);
        cv1.put("p_ad", p_ad);
        cv1.put("p_soyad", p_soyad);
        cv1.put("adres", adres);

        db.insertOrThrow("personel", null, cv1);
        Toast.makeText(getApplicationContext(), "Kayıt işlemi alındı..", Toast.LENGTH_LONG).show();
    }
    private void Kayitsil(String tc){
        SQLiteDatabase db=v2.getReadableDatabase();
        db.delete("personel","tc"+ "=" + tc,null);

        Toast.makeText(getApplicationContext(), "Silme işlemi alındı..", Toast.LENGTH_LONG).show();

    }





   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/



}
