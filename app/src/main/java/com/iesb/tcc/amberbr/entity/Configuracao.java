package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Configuracao implements Parcelable {
    private int raioAlertaLocal;
    private int raioAlertaPolicial;

    public Configuracao(){

    }

    public int getRaioAlertaLocal() {
        return raioAlertaLocal;
    }

    public void setRaioAlertaLocal(int raioAlertaLocal) {
        this.raioAlertaLocal = raioAlertaLocal;
    }

    public int getRaioAlertaPolicial() {
        return raioAlertaPolicial;
    }

    public void setRaioAlertaPolicial(int raioAlertaPolicial) {
        this.raioAlertaPolicial = raioAlertaPolicial;
    }

    //Parcelable Implementation
    protected Configuracao(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Configuracao> CREATOR = new Creator<Configuracao>() {
        @Override
        public Configuracao createFromParcel(Parcel in) {
            return new Configuracao(in);
        }

        @Override
        public Configuracao[] newArray(int size) {
            return new Configuracao[size];
        }
    };

}
