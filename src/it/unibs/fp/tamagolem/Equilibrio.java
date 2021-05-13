package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Equilibrio {
    private static final int[][] tabella = new int[Parametri.N][Parametri.N];

    public Equilibrio() {
    }

    /** fornisce la tabella
     * @return the tabella
     */
    public int[][] getTabella() {
        return tabella;
    }

    /**
     * genera l'equilibrio (CHE PER TETOFONTA VA BENE)
     */
    public static void generaTabella() {
        for (int i = 0; i < Parametri.N; i++) { // cicliamo sulle righe
            int sommaRiga = 0; // parametro per determinare l'ultimo elemento in modo "casuale" KEKW
            int j = 0;
            // estrazione esponente per avere numeri negativi (casuale per non avere pattern)
            int exp = EstrazioniCasuali.estraiIntero(0,50);
            while(j<Parametri.N) { //cicliamo sulle colonne
                if (i == j) { // la diagonale principale dev'essere nulla
                    tabella[i][j] = 0;
                    j++;
                }
                else if (j == Parametri.N - 1) { // quando arriviamo in fondo alla prima riga settiamo l'ultimo elemento cosi che la somma faccia 0
                    if(sommaRiga!=0){ // se la somma fino ad adesso non è 0 tutto ok
                        tabella[i][j] = -sommaRiga;
                        tabella[j][i] = -tabella[i][j]; // simmetrizzo
                        j++;
                    }
                    else { // questo è il caso sfigato dove la somma di tutti elementi prima fa già 0, dunque resettiamo tutta la riga
                        j--;
                    }
                }
                else if (j > i) { // j > i cosi da non riscrivere elementi già scritti in quanto ottenuti come simmetrici
                    tabella[i][j] = EstrazioniCasuali.estraiIntero(1, 5)*(int)Math.pow(-1,exp); // x * (-1)^y ==> otteniamo anche numeri negativi
                    sommaRiga += tabella[i][j]; // aggiungo il valore ottenuto alla somma degli elementi sulla riga
                    tabella[j][i] = -tabella[i][j]; // simmetrizzo
                    j++;
                }
                else{ // qui tengo conto nella somma anche degli elementi ottenuti simmetrizzando
                    sommaRiga+=tabella[i][j];
                    j++;
                }
            exp++; // aumento l'esponente di -1
            }
        }
    }

    /**
     * stampa l'equilibrio
     */
    public static void stampaTabella() {
        for (int i = 0; i < Parametri.N; i++) {
            for (int j = 0; j < Parametri.N; j++)
                System.out.print(tabella[i][j] + "\t");
            System.out.println();
        }
    }
}
