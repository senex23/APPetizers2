package com.example.appetizers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.appetizers.R.id.date;
import static com.example.appetizers.R.id.primo1;
import static com.example.appetizers.R.id.primo2;
import static com.example.appetizers.R.id.secondo2;

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

        /*BufferedReader reader = null;//DEBUG LETTURA FILE DI TESTO
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("test.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                TextView debug = (TextView) findViewById(primo2);
                debug.setText("Test riuscito: "+mLine);
            }
        } catch (IOException e) {}*/

        Piatto p;
        try {
            TextView debug = (TextView) findViewById(primo2);
            debug.setText("Blocco 0");
            InputStream is = getAssets().open("dati.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            debug.setText("Blocco 2");
            p = (Piatto)ois.readObject();
            debug.setText("Blocco 3");
            ois.close();

            TextView textP1 = (TextView) findViewById(primo1);
            textP1.setText(p.nome);
        } catch (Exception e) {
            TextView deb = (TextView) findViewById(secondo2);
            deb.setText(e.getStackTrace()[0].toString());
        }
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
