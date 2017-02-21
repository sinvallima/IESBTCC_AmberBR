package com.iesb.tcc.amberbr.entity;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public enum TipoAlerta {

    ALERTA_LOCAL(1, "Alerta Local"),
    ALERTA_POLICIAL(2, "Alerta Policial");

    private int id;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    private String nome;

    TipoAlerta(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
