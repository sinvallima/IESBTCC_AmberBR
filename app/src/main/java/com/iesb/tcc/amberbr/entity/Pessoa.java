package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Pessoa implements Parcelable {

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Short idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Short getIdade() {
        return idade;
    }

    public void setIdade(Short idade) {
        this.idade = idade;
    }

    //Parcelable Implementation
    protected Pessoa(Parcel in) {

        String[] data = new String[5];

        in.readStringArray(data);
        this.nome = data[0];
        this.sobrenome = data[1];
        this.email = data[2];
        this.telefone = data[3];
        this.idade = Short.valueOf(data[4]);

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
                this.getNome(),
                this.getSobrenome(),
                this.getEmail(),
                this.getTelefone(),
                String.valueOf(this.getIdade())});

    }


    public Pessoa(){

        this("Maria", "Cascuda", (short) -1);
    }

    public Pessoa(String nome, String sobrenome, short idade ){

        this(nome, sobrenome, idade, "", "");
    }

    public Pessoa(String nome, String sobrenome, short idade, String email, String telefone ){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

}
