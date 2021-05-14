package it.unibs.fp.tamagolem;
import java.util.ArrayList;

/**
 * Classe per la definizione di ciscuno dei due giocatori
 * */
public class Giocatore {
	private String nome;
	private int numeroTamagolemDisponibili;

	/**
	 * Costruttore del Tamagolem con l'aggiunta
	 * del quantitativo massimo di Tamagolem definito
	 * nella classe parametri dell'attributo G
	 * */
	public Giocatore(String nome) {
		this.nome = nome;
		this.numeroTamagolemDisponibili=Parametri.G;
	}

	/**
	 * Metodo per il controllo del quantitativo
	 * dei Tamagolem del giocatore corrente
	 * */
	public boolean isDied(){
		if(numeroTamagolemDisponibili<=0)
			return true;
		return false;
	}

	public int getNumeroTamagolemDisponibili() {
		return numeroTamagolemDisponibili;
	}

	public String getNome() {
		return nome;
	}

}
