package it.unibs.fp.tamagolem;
import java.util.ArrayList;

public class Giocatore {
	private String nome;
	private Arraylist<Tamagolem> tamagolem;
	private int numeroTamagolemDisponibili;
	
	public Giocatore(String nome) {
		this.nome = nome;
		this.tamagolem = new Arraylist<Tamagolem>();
	}
	
	public void inizializzaTamagolem() {
		//crei il tamagolem con nome, pietre...
	}
	
	public void inserisciGolem(Tamagolem t) {
		this.tamagolem.add(t);
	}
	
	public boolean isAlive() {
		//controlla vita tamagolem e dice se ne hai almeno uno da giocare
	if (numeroTamagolemDisponibili == 0) return false;
	return true;
	}
	

}
