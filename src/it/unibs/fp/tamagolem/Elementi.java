package it.unibs.fp.tamagolem;

public enum Elementi {
	FUOCO(0, "FUOCO"), 
	ACQUA(1, "ACQUA"), 
	TERRA(2, "TERRA"), 
	ARIA(3, "ARIA"), 
	LUCE(4, "LUCE"),
	TENEBRE(5, "TENEBRE"); 
	
	private int ordine;
	private String nome;

	Elementi(int ordine, String nome) {
	        this.ordine = ordine;
	        this.nome = nome;
	    }

	public int getordine() {
		return ordine;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
