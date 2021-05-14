package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Scontro {
    private ArrayList<Tamagolem> tamagolem=new ArrayList<Tamagolem>();
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem); // aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem);
    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();
    private ArrayList<Elemento> elementi=new ArrayList<Elemento>();
    private int tabella[][]=new int[6][6];


    private void inizializzazioneElementi(){
        elementi.add(Elemento.LUCE);
        elementi.add(Elemento.TENEBRE);
        elementi.add(Elemento.ACQUA);
        elementi.add(Elemento.ARIA);
        elementi.add(Elemento.TERRA);
        elementi.add(Elemento.FUOCO);
    }

    private void inizializzazionePietreTot(){
        int counter=0;
        inizializzazioneElementi();
        tabella=Equilibrio.getTabella();
        while(counter!=Parametri.S){
            for(int i=0;i<Parametri.A;i++)
                Pietra  pietra= new Pietra(elementi.get(i),);

                counter++;
            }


        }
    }
}