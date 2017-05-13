package com.example.appetizers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.appetizers.R.id.nomepiatto;

public class PaginaPiatto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_piatto);

        TextView nomedelpiatto = (TextView) findViewById(nomepiatto);

        Intent intent = getIntent(); // gets the previously created intent
        String nome = intent.getStringExtra("s");
        nomedelpiatto.setText(nome);

    }

    public void faiQualcosa(View v){

    }
}