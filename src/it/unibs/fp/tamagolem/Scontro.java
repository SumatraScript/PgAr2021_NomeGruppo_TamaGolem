package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;
import java.util.Queue;

public class Scontro {
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));// aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));
    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();
    private ArrayList<Elemento> elementi=new ArrayList<Elemento>();
    private int tamagolemg1;
    private int tamagolemg2;
    private int tabella[][]=new int[6][6];


    private void inizializzazioneElementi(){
        elementi.add(Elemento.ACQUA);
        elementi.add(Elemento.FUOCO);
        elementi.add(Elemento.ARIA);
        elementi.add(Elemento.TERRA);
        elementi.add(Elemento.LUCE);
        elementi.add(Elemento.TENEBRE);
    }

    private void inizializzazionePietreTot(){
        int counter=0;
        int contatore=0;
        inizializzazioneElementi();
        tabella=Equilibrio.getTabella();
        while(counter!=Parametri.S){
            for(int i=0;i<Parametri.A;i++) {
                Pietra pietra= new Pietra(elementi.get(contatore));
            }
            contatore++;
            counter++;
        }
    }

    private void evocazione

}