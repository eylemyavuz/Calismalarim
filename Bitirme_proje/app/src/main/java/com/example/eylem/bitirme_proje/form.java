package com.example.eylem.bitirme_proje;

import android.content.ContentValues;
import android.database.Cursor;
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

public class form extends AppCompatActivity {
    EditText tc,o_ad,o_soyad,v_ad,v_soyad,adres;
    TextView tcno,adi,soyadi,veliad,velisoyad,tw,o_adres;
    Button kaydet,kisiara,sil,güncelle;
    veritabani v1;
   // private static final String TABLE_NAME = "musteri_listesi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        v1 = new veritabani(this);
        tc = (EditText) findViewById(R.id.tc);
        o_ad = (EditText) findViewById(R.id.o_ad);
        o_soyad = (EditText) findViewById(R.id.o_soyad);
        v_ad = (EditText) findViewById(R.id.v_ad);
        v_soyad = (EditText) findViewById(R.id.v_soyad);
        adres = (EditText) findViewById(R.id.adres);

        tcno = (TextView) findViewById(R.id.tv1);
        adi = (TextView) findViewById(R.id.tv2);
        soyadi = (TextView) findViewById(R.id.tv3);
        veliad = (TextView) findViewById(R.id.tv4);
        velisoyad = (TextView) findViewById(R.id.tv5);
        o_adres = (TextView) findViewById(R.id.tv6);

        kaydet = (Button) findViewById(R.id.btn_kaydet);
        kisiara = (Button) findViewById(R.id.btn_ara);
        sil = (Button) findViewById(R.id.btn_sil);
        güncelle = (Button) findViewById(R.id.btn_güncelle);
        tw = (TextView) findViewById(R.id.tw);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Kayitekle(tc.getText().toString(), o_ad.getText().toString(), o_soyad.getText().toString(), v_ad.getText().toString(), v_soyad.getText().toString(), adres.getText().toString());
                    // Cursor cursor = KayitGetir();KayitGoster(cursor);

                } finally {
                    v1.close();
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
    private void Kayitekle(String tc,String o_ad,String o_soyad,String v_ad,String v_soyad,String adres) {
        SQLiteDatabase db = v1.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("tc", tc);
        cv1.put("o_ad", o_ad);
        cv1.put("o_soyad", o_soyad);
        cv1.put("v_ad", v_ad);
        cv1.put("v_soyad", v_soyad);
        cv1.put("adres", adres);

        db.insertOrThrow("kisiler", null, cv1);
        Toast.makeText(getApplicationContext(), "Kayıt işlemi alındı..", Toast.LENGTH_LONG).show();
    }
    private void Kayitsil(String tc){
        SQLiteDatabase db=v1.getReadableDatabase();
        db.delete("kisiler","tc"+ "=" + tc,null);

        Toast.makeText(getApplicationContext(), "Silme işlemi alındı..", Toast.LENGTH_LONG).show();

    }



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

