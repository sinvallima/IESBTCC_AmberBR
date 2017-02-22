package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Usuario extends Pessoa implements Parcelable{

    private String idFacebook;

    protected Usuario(Parcel in) {

        //super(in);

        String[] data = new String[6];

        in.readStringArray(data);
        this.setNome(data[0]);
        this.setSobrenome(data[1]);
        this.setEmail(data[2]);
        this.setTelefone(data[3]);
        this.setIdade(Short.valueOf(data[4]));
        this.setIdFacebook(data[5]);

    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.getNome(),
                this.getSobrenome(),
                this.getEmail(),
                this.getTelefone(),
                String.valueOf(this.getIdade()),
                this.getIdFacebook()});

    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };

    public Usuario(){
        super();
        this.idFacebook = "";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.idFacebook == ((Usuario)obj).idFacebook;
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

}
