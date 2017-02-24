package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Localizacao implements Parcelable {

    private double latitude;
    private double longitude;
    private String nome;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Parcelable Implementation
    protected Localizacao(Parcel in) {

        String[] data = new String[3];

        in.readStringArray(data);
        this.setLatitude(Double.valueOf(data[0]));
        this.setLongitude(Double.valueOf(data[1]));
        this.setNome(data[2]);

    }

    public Localizacao(){
        this.nome = "";
    }

    @Override
    public boolean equals(Object obj) {
        Localizacao loc = (Localizacao)obj;

        return (loc.getLatitude() == this.getLatitude() && loc.getLongitude() == this.getLongitude());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                String.valueOf(this.getLatitude()),
                String.valueOf(this.getLongitude()),
                this.getNome()});

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Localizacao> CREATOR = new Creator<Localizacao>() {
        @Override
        public Localizacao createFromParcel(Parcel in) {
            return new Localizacao(in);
        }

        @Override
        public Localizacao[] newArray(int size) {
            return new Localizacao[size];
        }
    };

}
