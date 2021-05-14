package it.unibs.fp.tamagolem;

/**
 * a samu va bene
 * */
public class Parametri {
	//numero di tipologie di pietre(elementi disponibili)
	final static public double N = 6;
	//numero pietre che può ingurgitare Tamagolem
	final static public double P = (double) Math.ceil((N + 1) / 3) + 1 ;
	//numero di Tamagolem per giocatore
	final static public double G = (double) Math.ceil((N - 1)*(N - 2) / (2 * P)) ;
	//numero totale di pietre da cui i giocatori possono pescare s=18
	final static public double S = (double) Math.ceil((2 * G * P) / N) * N;
	//numero di pietre per elemento
	final static public double A = S/N;
	//vita di ogni Tamagolem
    final static public int V = 20;

    //Stringhe costanti
    final static public String MSG = "INSERISCA NOME";
}
