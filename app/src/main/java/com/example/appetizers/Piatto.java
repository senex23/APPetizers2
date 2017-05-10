package com.example.appetizers;

import java.io.Serializable;

public class Piatto implements Serializable {
    private static final long serialVersionUID = 1L;
    String nome;
    String[] ingredienti;
    String descrizione;

    public Piatto(String nome,String descrizione){
        this.nome = nome;
        this.descrizione = descrizione;
    }
}