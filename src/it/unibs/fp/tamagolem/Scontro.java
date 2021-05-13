package it.unibs.fp.tamagolem;

import java.util.ArrayList;

public class Scontro {
    private ArrayList<Tamagolem> tamagolem=new ArrayList<Tamagolem>();
    private Giocatore g1 = new Giocatore(tamagolem);
    private Giocatore g2 = new Giocatore(tamagolem);
    private ArrayList<Pietre> pietre=new ArrayList<Pietre>();
}