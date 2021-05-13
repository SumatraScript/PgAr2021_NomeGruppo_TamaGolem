package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Scontro {
    private ArrayList<Tamagolem> tamagolem=new ArrayList<Tamagolem>();
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem); // aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG),tamagolem);
    //private ArrayList<Pietre> pietre=new ArrayList<Pietre>(); commentata perchè vi è riferimento a Pietra
}