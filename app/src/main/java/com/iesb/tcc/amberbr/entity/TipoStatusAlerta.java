package com.iesb.tcc.amberbr.entity;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public enum TipoStatusAlerta {

    ABERTO_ALERTA_LOCAL(10, "Aberto Alerta Local"),
    ABERTO_ALERTA_POLICIAL(20, "Aberto Alerta Policial"),
    CONFIRMADO_ALERTA_POLICIAL(30, "Confirmado Alerta Policial"),
    ALERTA_ENCERRADO(40, "Alerta Encerrado");

    private int id;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    private String nome;

    TipoStatusAlerta(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
