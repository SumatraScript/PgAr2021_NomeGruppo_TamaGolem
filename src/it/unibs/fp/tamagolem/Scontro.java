package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.MyMenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Scontro {
    public static final String MENU_INSERIMENTO_PIETRE = "Menu inserimento pietre scegli un massimo di 4 Pietre";
    public static final String MSG_NON_DIPONIBILITA_PIETRA = "La pietra non è più diponibile prego selezionarne un altra";
    public static final String MSG_VINCITORE = "Complimenti! Ha vinto il giocatore %s con %d vittorie su %d round";
    public static final String MSG_ERRORE = "Il Giocatore %s ha finito i suoi tamagolem";

    private ArrayList<Pietra> pietreTot=new ArrayList<Pietra>();
    private ArrayList<String> nomiPietre=new ArrayList<String>();

    /**
     * Metodo Costruttore che permette lo scontro tra i due giocatori
     * */
    public Scontro(Giocatore g1, Giocatore g2, Equilibrio equilibrio){
        inizializzazionePietreTot();

        int vittorieG1=0;
        int vittorieG2=0;

        Tamagolem tama1=evocazioneTamagolem(g1);
        Tamagolem tama2=evocazioneTamagolem(g2);

        //scontro vero e proprio che continua finquando il valore di tamaGolem disponibili di un giocatore si azzera;
        while(g1.getNumeroTamagolemDisponibili()!=0 || g2.getNumeroTamagolemDisponibili()!=0){
            if(!evocazioneTamagolem(g1).equals(null) && !evocazioneTamagolem(g2).equals(null)){

                //turno di gioco tra due tamagolem
                while(tama1.getVitaAttuale()!=0 || tama2.getVitaAttuale()!=0){
                    int danni = scontroDuePietre(tama1.sputa(), tama2.sputa(), equilibrio);
                    //se i danni sono negativi significa che la pietra p1 è stata battuta della p2 nel combattimento
                    //controllovitaTama mi permette di verificare che la vita del tamaGolem non vada sotto 0 se si la setto a 0
                    if(danni<=0)
                        tama1.setVitaAttuale(controlloVitaTama(tama1.getVitaAttuale() - Math.abs(danni)));
                    else
                        tama2.setVitaAttuale(controlloVitaTama(tama2.getVitaAttuale() - Math.abs(danni)));
                }

                if(tama1.getVitaAttuale()==0){
                    vittorieG2++;
                    tama1=evocazioneTamagolem(g1);
                }

                else{
                    vittorieG2++;
                    tama2=evocazioneTamagolem(g1);
                }
            }
            else{
                if(g1.isDied())
                    System.out.println(String.format(MSG_ERRORE, g1.getNome()));
                else
                    System.out.println(String.format(MSG_ERRORE, g2.getNome()));
            }
        }


        //rilevazione del vincitore e dell'equilibrio
        if(rilevazioneVincitore(vittorieG1,vittorieG2))
            System.out.println(String.format(MSG_VINCITORE,g1.getNome(),vittorieG1,Parametri.G));
        else
            System.out.println(String.format(MSG_VINCITORE,g2.getNome(),vittorieG2,Parametri.G));
        equilibrio.stampaTabella();
    }

    /**
     * Metodo per l'inizializzazione delle PietreTotali
     * */
    private void inizializzazionePietreTot(){
        int counter=0;
        int contatore=0;
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
        //Controllo ulteriore sulla corretteza del codice
        else{
            return null;
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

    /**
     * Metodo che mi permette di verificare
     * che la vita del tamaGolem non vada sotto
     * 0 se si la setto a 0
     * */
    private int controlloVitaTama(int vitaTama){
        if(vitaTama<=0)
            return 0;
        else
            return vitaTama;
    }

    /**
     * Metodo che permette la genenerazione
     * di boolean al fine di determinare un vincitore
     * ritorna true se il giocatore g1 ha vinto altrimenti false
     * */
    private boolean rilevazioneVincitore(int v1, int v2){
        if(v1>=v2)
            return true;
        else
            return false;
    }

    /**
     * Metodo che permette il controllo della nome della pietra
     * esso una volta aver ricevuto una pietra ritorna un valore
     * intero che rappresenta l'insice in termini di righe e di
     * colonne di tale pietra
     * */
    private int controlloNomePietra(Pietra pietra){
        int index=0;
        if(pietra.getNome().equals(Elemento.ACQUA.name()))
            index=0;
        else if(pietra.getNome().equals(Elemento.FUOCO.name()))
            index=1;
        else if(pietra.getNome().equals(Elemento.ARIA.name()))
            index=2;
        else if(pietra.getNome().equals(Elemento.TERRA.name()))
            index=3;
        else if(pietra.getNome().equals(Elemento.LUCE.name()))
            index=4;
        else if(pietra.getNome().equals(Elemento.TENEBRE.name()))
            index=5;
        return index;
    }

    /**
     * Metodo Implementativo che permette lo scontro tra 2
     * pietre esso ricava dalla tabella dell'equilibrio i valori
     * di danno e li passa al costruttore della classe ovvero Scontro
     * */
    private int scontroDuePietre(Pietra p1,Pietra p2, Equilibrio equilibrio){
        int danni=0;
        // se hanno lo stesso nome il loro danno è nullo
        if(p1.getNome().equals(p2.getNome())){
            danni=0;
        }
        else{
            int i=0,j=0;
            //controllo il nome della pietra 1 e ritorno il suo indice
            i=controlloNomePietra(p1);
            j=controlloNomePietra(p2);
            danni=equilibrio.getTabella()[i][j];
        }
        return danni;
    }

}