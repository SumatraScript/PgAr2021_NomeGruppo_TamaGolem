package it.unibs.fp.tamagolem;

import java.util.Random;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Equilibrio {
    private final int NUM_ELEMENTI = 6;
    private int tabella[][] = new int[NUM_ELEMENTI][NUM_ELEMENTI];

    public Equilibrio() {
    }

    /**
     * @return the tabella
     */
    public int[][] getTabella() {
        return tabella;
    }

    public void generaTabella() {
        for (int i = 0; i < NUM_ELEMENTI; i++) {
            int sommaRiga = 0;
            int j=0;
            int n=(int)Math.random();
            while(j<NUM_ELEMENTI) {
                if (i == j) {
                    tabella[i][j] = 0;
                    j++;
                }
                else if (j == 5) {
                    if(sommaRiga!=0){
                        tabella[i][j] = -sommaRiga;
                        tabella[j][i] = -tabella[i][j];
                        j++;
                    }
                    else {
                        j--;
                    }
                }
                else if (j > i) {
                    tabella[i][j] = EstrazioniCasuali.estraiIntero(1, 5)*(int)Math.pow(-1,n);
                    sommaRiga += tabella[i][j];
                    tabella[j][i] = -tabella[i][j];
                    j++;
                }
                else{
                    sommaRiga+=tabella[i][j];
                    j++;
                }
            n++;
            }
        }
    }

    public void stampaTabella() {
        for (int i = 0; i < NUM_ELEMENTI; i++) {
            for (int j = 0; j < NUM_ELEMENTI; j++)
                System.out.print(tabella[i][j] + "\t");
            System.out.println();
        }
    }
}
