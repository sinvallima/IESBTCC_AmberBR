package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Usuario extends Pessoa {

    private String idFacebook;

    protected Usuario(Parcel in) {
        super(in);
    }

    public Usuario(){
        super();
        this.idFacebook = "";
    }

    public String getIdFacebook() {
        return idFacebook;
    }

    public void setIdFacebook(String idFacebook) {
        this.idFacebook = idFacebook;
    }

}
