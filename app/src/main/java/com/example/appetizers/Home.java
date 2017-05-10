package com.example.appetizers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Piatto p = null;
        try {
            TextView tw1 = (TextView) findViewById(R.id.primo2);
            tw1.setText("blocco1");
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()+ File.separator+"pene.txt";
            tw1.setText(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath()+ File.separator+"pene.txt");
            FileInputStream fis = new FileInputStream(new File(path));
            tw1.setText("blocco2");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tw1.setText("blocco3");
            p = (Piatto)ois.readObject();
            tw1.setText("blocco4");
            ois.close();
            fis.close();
            TextView tw = (TextView) findViewById(R.id.primo1);
            tw.setText(p.nome);
        }catch(Exception e){
            TextView twe = (TextView) findViewById(R.id.contorno2);
            twe.setText(e.getStackTrace().toString());
        }


        /*setContentView(R.layout.activity_home);
        FirebaseDatabase database = null;
        if(!FirebaseApp.getApps(this).isEmpty()) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Costa!Costa!Costa!");*/
    }

    public void vaiAlPiatto(View view){
        Intent intent = new Intent(Home.this, PaginaPiatto.class);
        startActivity(intent);
    }


}
