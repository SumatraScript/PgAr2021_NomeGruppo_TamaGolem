package it.unibs.fp.tamagolem;

import it.unibs.fp.mylib.InputDati;

/**
 * Classe che implementa UI da righa di comando;
 */
public class Main {

	public static final String MSG_NOME_GIOCATORE = "Inserisci il Nome del giocatore: ";

	public static void main(String[] args) {
		Equilibrio equilibrio = new Equilibrio();
		Giocatore g1 = creaGiocatore();
		Giocatore g2 = creaGiocatore();
		Scontro.Scontroso(g1, g2, equilibrio);
	}

	private static Giocatore creaGiocatore() {
		String nome = InputDati.leggiStringaNonVuota(MSG_NOME_GIOCATORE);
		Giocatore giocatore = new Giocatore(nome);
		return giocatore;
	}
}
