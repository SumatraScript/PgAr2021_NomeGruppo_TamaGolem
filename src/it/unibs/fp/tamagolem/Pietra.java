package it.unibs.fp.tamagolem;

import java.util.Objects;

/**
 * Classe pietra creata per la necessità
 * di conciliazione tra le classe scritte
 * */
public class Pietra {
    private String nome;

    public Pietra(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pietra other = (Pietra) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
    
}
