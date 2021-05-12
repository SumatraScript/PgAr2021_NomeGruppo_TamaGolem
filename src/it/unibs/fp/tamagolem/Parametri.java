package it.unibs.fp.tamagolem;


public class Parametri {
	final public int N = 6;
	final public int P = (int) Math.ceil((N + 1) / 3) + 1 ;
	final public int G = (int) Math.ceil((N - 1)*(N - 2) / (2 * P)) ;
	final public int S = (int) Math.ceil((2 * G * P) / N) * N;
    // int V = VITA_MAX massimo valore dell'Equilibrio
}
