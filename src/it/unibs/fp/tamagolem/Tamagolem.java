package it.unibs.fp.tamagolem;

import java.util.Queue;
/**
 * Classe per la generazione del Tamagolem
 * */
public class Tamagolem {
    private Queue<Pietra> pietre;
    private int vitaAttuale;

    /**
     * Costruttore del Tamagolem con l'aggiunta
     * del valore di vita massimo definito nella
     * classe parametri dell'attributo V
     * */
    public Tamagolem(Queue<Pietra> pietre) {
        this.pietre = pietre;
        this.vitaAttuale = Parametri.V;
    }

    public Queue<Pietra> getPietre() {
        return pietre;
    }

    public void setPietre(Queue<Pietra> pietre) {
        this.pietre = pietre;
    }

    public int getVitaAttuale() {
        return vitaAttuale;
    }

    public void setVitaAttuale(int vita_attuale) {
        this.vitaAttuale = vita_attuale;
    }

   /**
    * Metodo che permette di implemetare
    * il ciclo di sputaggio
    * */
   public Pietra sputa() {
        // aggiungo l'elemento, che era in fondo, in testa alla coda (returnato da poll) e poi lo rimuovo (sempre con poll)
        Pietra pietraPollata= pietre.poll();
        this.pietre.add(pietraPollata);
        return pietraPollata;
    }
}
