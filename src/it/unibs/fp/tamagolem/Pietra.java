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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pietra pietra = (Pietra) o;
        return Objects.equals(nome, pietra.nome);
    }
}
