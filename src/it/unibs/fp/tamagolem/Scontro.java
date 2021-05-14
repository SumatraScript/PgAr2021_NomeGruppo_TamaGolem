package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Scontro {
    public static final String MENU_INSERIMENTO_PIETRE = "Menu inserimento pietre scegli un massimo di 4 Pietre";
    public static final String MSG_NON_DIPONIBILITA_PIETRA = "La pietra non è più diponibile prego selezionarne un altra";
    private Giocatore g1 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));// aggiunta della richesta del nome cfr. costruttore Giocatore
    private Giocatore g2 = new Giocatore(InputDati.leggiStringaNonVuota(Parametri.MSG));

    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();
    private ArrayList<String> nomiPietre=new ArrayList<String>();
    private int tabella[][]=new int[6][6];


    private void inizializzazioneElementi(){
        nomiPietre.add(Elemento.ACQUA.name());
        nomiPietre.add(Elemento.FUOCO.name());
        nomiPietre.add(Elemento.ARIA.name());
        nomiPietre.add(Elemento.TERRA.name());
        nomiPietre.add(Elemento.LUCE.name());
        nomiPietre.add(Elemento.TENEBRE.name());
    }

    /**
     * Metodo per l'inizializzazione delle PietreTotali
     * */
    private void inizializzazionePietreTot(){
        int counter=0;
        int contatore=0;
        inizializzazioneElementi();
        //aggiunta di S pietre totali
        while(counter!=Parametri.S){
            //aggiunta di a pietre di un tipo
            for(int i=0;i<Parametri.A;i++) {
                Pietra pietra= new Pietra(nomiPietre.get(contatore));
            }
            contatore++;
            counter++;
        }
    }

    /**
     * Metodo che permette l'evocazione di un tamagolem
     * esso chiama il metodo di inserimento pietre per iniziallizzare una
     * Queue di Pietre
     * */
    private Tamagolem evocazioneTamagolem(Giocatore giocatore){
        if(!giocatore.isDied()){
            Tamagolem tama= new Tamagolem(inserimentoPietreTamagolem());
            return tama;
        }
        else{
            // if(rilevazioneVincitore())
            System.out.println("Il giocatore: "+ giocatore.getNome()+" ha finito i sui tamagolem");
        }
    }

    /**
     * Metodo per l'iserimento delle pietre nel tamagolem
     * */
    private Queue<Pietra> inserimentoPietreTamagolem() {

        int scelta;
        int counter=0;
        Queue<Pietra> sceltaPietre =new LinkedList<>();
        MyMenu menuSceltaPietre= new MyMenu(MENU_INSERIMENTO_PIETRE, new String[]{
                Elemento.ACQUA.name(),
                Elemento.FUOCO.name(),
                Elemento.ARIA.name(),
                Elemento.TERRA.name(),
                Elemento.LUCE.name(),
                Elemento.TENEBRE.name()
        });
        do {
            scelta= menuSceltaPietre.scegli();
            switch(scelta){
                //per ogni caso controlla che la pietra da inserire non sia contenuta ne all'interno della scelta pietre
                case 1:
                    if(pietreTot.contains(new Pietra(Elemento.ACQUA.name())) && !sceltaPietre.contains(new Pietra(Elemento.ACQUA.name())))
                        sceltaPietre.add(new Pietra(Elemento.ACQUA.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
                case 2:
                    if(pietreTot.contains(new Pietra(Elemento.FUOCO.name())) && !sceltaPietre.contains(new Pietra(Elemento.FUOCO.name())))
                        sceltaPietre.add(new Pietra(Elemento.FUOCO.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
                case 3:
                    if(pietreTot.contains(new Pietra(Elemento.ARIA.name())) && !sceltaPietre.contains(new Pietra(Elemento.ARIA.name())))
                        sceltaPietre.add(new Pietra(Elemento.ARIA.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
                case 4:
                    if(pietreTot.contains(new Pietra(Elemento.TERRA.name())) && !sceltaPietre.contains(new Pietra(Elemento.TERRA.name())))
                        sceltaPietre.add(new Pietra(Elemento.TERRA.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
                case 5:
                    if(pietreTot.contains(new Pietra(Elemento.LUCE.name())) && !sceltaPietre.contains(new Pietra(Elemento.LUCE.name())))
                        sceltaPietre.add(new Pietra(Elemento.LUCE.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
                case 6:
                    if(pietreTot.contains(new Pietra(Elemento.TENEBRE.name())) && !sceltaPietre.contains(new Pietra(Elemento.TENEBRE.name())))
                        sceltaPietre.add(new Pietra(Elemento.TENEBRE.name()));
                    else
                        System.out.println(MSG_NON_DIPONIBILITA_PIETRA);
                    break;
            }
            counter++;
            //modificata la classe MyMenu per non rendere disponibile il valore di uscita=0
        }while(counter!=Parametri.P);
        return sceltaPietre;
    }

    public Scontro(Giocatore g1, Giocatore g2, Equilibrio equilibrio){
        this.g1=g1;
        this.g2=g2;
        inizializzazionePietreTot();
        for(int i=0;i<Parametri.G;i++){
            Tamagolem tama1=evocazioneTamagolem(g1);
            Tamagolem tama2=evocazioneTamagolem(g2);
            while(tama1.getVitaAttuale()!=0 || tama2.getVitaAttuale()!=0){
                scontroDuePietre(tama1.sputa(), tama2.sputa());

            }
        }
    }

    public int scontroDuePietre(Pietra p1,Pietra p2){
        int danni=0;
        return danni;
    }

}