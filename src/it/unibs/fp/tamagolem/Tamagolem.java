package it.unibs.fp.tamagolem;

import java.util.Queue;

public class Tamagolem {
   // private Queue<Pietra> pietre = new Queue<Pietra>(); // commenti = robe con dentro classe Pietra
    private int vita_attuale;

    public Tamagolem(/*Queue<Pietra> pietre*/) {
     //   this.pietre = pietre;
        this.vita_attuale = Parametri.V;
    }

    /*public Queue<Pietra> getPietre() {
        return pietre;
    }

    public void setPietre(Queue<Pietra> pietre) {
        this.pietre = pietre;
    }*/

    public int getVita_attuale() {
        return vita_attuale;
    }

    public void setVita_attuale(int vita_attuale) {
        this.vita_attuale = vita_attuale;
    }

   /**
     * compone il nostro ciclo di sputaggio
     */
   /* public void sputa() {
        // aggiungo l'elemento, che era in fondo, in testa alla coda (returnato da poll) e poi lo rimuovo (sempre con poll)
        this.pietre.add(pietre.poll());
    }*/
}
