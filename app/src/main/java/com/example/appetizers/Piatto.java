package com.example.appetizers;

public class Piatto{
    String nome;
    String[] ingredienti;
    String descrizione;

    public Piatto(String nome,String descrizione,String[] ingr){
        ingredienti = ingr;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Piatto(String s){
        String[] xd = s.split("#");
        nome = xd[0];
        descrizione = xd[1];
        ingredienti = new String[xd.length-2];
        for(int i=2;i<xd.length;i++){
            ingredienti[i-2]=xd[i];
        }
    }

    public String toFile(){
        String s = "";
        s+=nome+"#";
        s+=descrizione+"#";
        for(String box:ingredienti){
            s+=box+"#";
        }
        return s+"\n";
    }
}