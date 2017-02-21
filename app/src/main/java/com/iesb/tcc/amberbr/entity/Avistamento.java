package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Avistamento implements Parcelable {

    private double id;
    private Localizacao localizacao;
    private Date dataHoraAvistamento;
    private String descricao;
    private List<Foto> fotos;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Date getDataHoraAvistamento() {
        return dataHoraAvistamento;
    }

    public void setDataHoraAvistamento(Date dataHoraAvistamento) {
        this.dataHoraAvistamento = dataHoraAvistamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    //Parcelable Implementation
    protected Avistamento(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Avistamento> CREATOR = new Creator<Avistamento>() {
        @Override
        public Avistamento createFromParcel(Parcel in) {
            return new Avistamento(in);
        }

        @Override
        public Avistamento[] newArray(int size) {
            return new Avistamento[size];
        }
    };

}
