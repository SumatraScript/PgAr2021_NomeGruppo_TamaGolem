package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Scontro {
    private ArrayList<Tamagolem> tamagolem=new ArrayList<Tamagolem>();
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem); // aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem);
    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();

    private void inizializzazionePietreTot(){
        int counter=0;
        while(counter!=Parametri.S){
            for(int i=0;i<Parametri.)


        }
    }
}