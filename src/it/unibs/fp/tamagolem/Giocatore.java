package it.unibs.fp.tamagolem;
import java.util.ArrayList;

public class Giocatore {
	private String nome;
	private int numeroTamagolemDisponibili=Parametri.G;
	
	public Giocatore(String nome) {
		this.nome = nome;
	}

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
