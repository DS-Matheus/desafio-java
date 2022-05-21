package models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente implements Comparable<Cliente> {

    private String Nome;

    public Cliente(String nome) {
        Nome = nome;
    }

    @Override
    public int compareTo(Cliente c) {
        return this.getNome().compareToIgnoreCase(c.getNome());
    }
}
