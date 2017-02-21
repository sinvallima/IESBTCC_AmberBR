package com.iesb.tcc.amberbr.entity;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public enum TipoDesaparecimento {
    PERDIDO(1, "Perdido"),
    POSSIVEL_SEQUESTRO(2, "Possível Sequestro"),
    FUGA_DE_CASA(3, "Fugiu de Casa");

    private int id;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    private String nome;

    TipoDesaparecimento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
