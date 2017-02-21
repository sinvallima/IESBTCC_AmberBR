package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Foto implements Parcelable {

    private double id;
    private String imagem;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    //Parcelable Implementation
    protected Foto(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Foto> CREATOR = new Creator<Foto>() {
        @Override
        public Foto createFromParcel(Parcel in) {
            return new Foto(in);
        }

        @Override
        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };
}
