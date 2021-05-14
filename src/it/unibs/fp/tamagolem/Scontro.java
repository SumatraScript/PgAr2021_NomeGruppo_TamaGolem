package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

import java.util.ArrayList;

public class Scontro {
    public static final String MENU_INSERIMENTO_PIETRE = "Menu inserimento pietre";
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));// aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));

    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();
    private ArrayList<Elemento> elementi=new ArrayList<Elemento>();
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

    private Tamagolem evocazioneTamagolem(Giocatore giocatore){
        if(!giocatore.isDied()){
            MyMenu menuSceltaPietre= new MyMenu(MENU_INSERIMENTO_PIETRE, new String[]{
                    Elemento.ACQUA.name(),
                    Elemento.FUOCO.name(),
                    Elemento.ARIA.name(),
                    Elemento.TERRA.name(),
                    Elemento.LUCE.name(),
                    Elemento.TENEBRE.name()
            });

            Tamagolem tama= new Tamagolem();
            return tama;
        }
        else
            System.out.println("Il giocatore: "+ giocatore.getNome()+"ha finito i sui tamagolem");

    }

}