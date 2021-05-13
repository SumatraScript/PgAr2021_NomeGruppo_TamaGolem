package it.unibs.fp.tamagolem;


public class Parametri {
	final static public int N = 6;
	final static public int P = (int) Math.ceil((N + 1) / 3) + 1 ;
	final static public int G = (int) Math.ceil((N - 1)*(N - 2) / (2 * P)) ;
	final static public int S = (int) Math.ceil((2 * G * P) / N) * N;
    final static public int V = 20;
    final static public String MSG = "INSERISCA NOME";
}
