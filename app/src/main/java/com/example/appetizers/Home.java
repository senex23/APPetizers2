package com.example.appetizers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Piatto p = null;
        try {
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            p = (Piatto)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e){}
        TextView tw = (TextView) findViewById(R.id.primo1);
        tw.setText(p.nome);

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
