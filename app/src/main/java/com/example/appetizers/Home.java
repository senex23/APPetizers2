package com.example.appetizers;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.appetizers.R.id.date;
import static com.example.appetizers.R.id.primo1;
import static com.example.appetizers.R.id.primo2;

public class Home extends AppCompatActivity {

    public Calendar oggi;
    public Calendar datachevedo;
    public TextView textDate;
    public SimpleDateFormat sdf;
    public Date giorno;
    public Date giornochevedo;
    public Date today;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        oggi = Calendar.getInstance();
        datachevedo = (Calendar) oggi.clone();

        textDate = (TextView) findViewById(date);
        giorno = datachevedo.getTime();

        sdf = new SimpleDateFormat("E dd/MM");
        String dateString = sdf.format(giorno);
        textDate.setText(dateString);

        BufferedReader reader = null;
        try {
            TextView debug = (TextView) findViewById(primo2);
            AssetManager am = getAssets();
            InputStream is = am.open("mydati2.txt");
            InputStreamReader isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                Piatto p = new Piatto(mLine);
                TextView tw = (TextView) findViewById(primo1);
                tw.setText(p.nome);
            }
        } catch (Exception e) {}
    }

    public void vaiAlPiatto(View view){
        String s ="penepenepene";
        Intent intent = new Intent(Home.this, PaginaPiatto.class);
        intent.putExtra("s", s);
        startActivity(intent);
    }

    public void dataAvanti (View view) {
        today = oggi.getTime();
        giornochevedo = datachevedo.getTime();
        long diff = giornochevedo.getTime() - today.getTime();
        if (diff < (86400000*3)) { /*Questa differenza è in fottuti millisecondi, io ho bisogno dei cazzo di giorni!*/
            datachevedo.add(Calendar.DATE, 1);
            //textDate = (TextView) findViewById(date);
            giorno = datachevedo.getTime();

            sdf = new SimpleDateFormat("E dd/MM");
            String dateString = sdf.format(giorno);
            textDate.setText(dateString);
        }
    }

    public void dataIndietro (View view) {
        today = oggi.getTime();
        giornochevedo = datachevedo.getTime();
        long diff = today.getTime() - giornochevedo.getTime();
        if (diff < (86400000*3)) {
            datachevedo.add(Calendar.DATE, -1);
            //textDate = (TextView) findViewById(date);
            giorno = datachevedo.getTime();

            sdf = new SimpleDateFormat("E dd/MM");
            String dateString = sdf.format(giorno);
            textDate.setText(dateString);
        }
    }

    public void tornaOggi (View view) {
        datachevedo = (Calendar) oggi.clone();
        //textDate = (TextView) findViewById(date);
        giorno = datachevedo.getTime();

        sdf = new SimpleDateFormat("E dd/MM");
        String dateString = sdf.format(giorno);
        textDate.setText(dateString);
    }
}
