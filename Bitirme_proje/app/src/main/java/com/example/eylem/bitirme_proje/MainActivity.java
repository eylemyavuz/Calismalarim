package com.example.eylem.bitirme_proje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button veritabani,button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        veritabani = (Button) findViewById(R.id.veritabani);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);

    }
    public void Tiklandi(View v) {
        if (v.getId() == R.id.veritabani) {
            Intent intent = new Intent(getApplicationContext(), form.class);
            startActivity(intent);

        }
    }
    public void Tiklandi1(View v) {
        if (v.getId() == R.id.button) {
            Intent intent = new Intent(getApplicationContext(), personel.class);
            startActivity(intent);

        }
    }
    public void Tiklandi2(View v) {
        if (v.getId() == R.id.button1) {
            Intent intent = new Intent(getApplicationContext(), aracislemleri.class);
            startActivity(intent);

        }

    }


























   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
