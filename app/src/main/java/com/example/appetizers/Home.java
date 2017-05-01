package com.example.appetizers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FirebaseDatabase database = null;
        if(!FirebaseApp.getApps(this).isEmpty()) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Costa!Costa!Costa!");
    }

    public void vaiAlPiatto(View view){
        Intent intent = new Intent(Home.this, PaginaPiatto.class);
        startActivity(intent);
    }
}
