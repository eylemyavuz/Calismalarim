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

public class aracislemleri extends AppCompatActivity {

    EditText tc,plaka1;
    TextView tcno,plaka,tw;
    Button kaydet,kisiara,sil,güncelle;
    veritabani v3;
    // private static final String TABLE_NAME = "musteri_listesi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aracislemleri);



        v3 = new veritabani(this);
        tc = (EditText) findViewById(R.id.tc);
        plaka1 = (EditText) findViewById(R.id.plaka);

        tcno = (TextView) findViewById(R.id.a1);
        plaka = (TextView) findViewById(R.id.a2);


        kaydet = (Button) findViewById(R.id.btn_kaydet);
        kisiara = (Button) findViewById(R.id.btn_ara);
        sil = (Button) findViewById(R.id.btn_sil);
        güncelle = (Button) findViewById(R.id.btn_güncelle);
        tw = (TextView) findViewById(R.id.tw);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Kayitekle(tc.getText().toString(), plaka1.getText().toString());
                    // Cursor cursor = KayitGetir();KayitGoster(cursor);

                } finally {
                    v3.close();
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
    private void Kayitekle(String tc,String plaka1) {
        SQLiteDatabase db = v3.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("tc", tc);
        cv1.put("plaka1", plaka1);

        db.insertOrThrow("araclar", null, cv1);
        Toast.makeText(getApplicationContext(), "Kayıt işlemi alındı..", Toast.LENGTH_LONG).show();
    }
    private void Kayitsil(String tc){
        SQLiteDatabase db=v3.getReadableDatabase();
        db.delete("araclar","tc"+ "=" + tc,null);

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


