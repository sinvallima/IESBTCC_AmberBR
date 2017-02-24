package com.iesb.tcc.amberbr.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class Alerta implements Parcelable {

    private double id;
    private TipoAlerta tipoAlerta;
    private TipoStatusAlerta status;
    private Usuario emissor;
    private Localizacao localizacao;
    private Date dataHoraAbertura;
    private Pessoa desaparecido;
    private Date ultimaAtualizacao;
    private Boolean encontrado;
    private TipoDesaparecimento tipoDesaparecimento;
    private List<Foto> fotos;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public TipoAlerta getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(TipoAlerta tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public TipoStatusAlerta getStatus() {
        return status;
    }

    public void setStatus(TipoStatusAlerta status) {
        this.status = status;
    }

    public Usuario getEmissor() {
        return emissor;
    }

    public void setEmissor(Usuario emissor) {
        this.emissor = emissor;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Pessoa getDesaparecido() {
        return desaparecido;
    }

    public void setDesaparecido(Pessoa desaparecido) {
        this.desaparecido = desaparecido;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Boolean getEncontrado() {
        return encontrado;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    public TipoDesaparecimento getTipoDesaparecimento() {
        return tipoDesaparecimento;
    }

    public void setTipoDesaparecimento(TipoDesaparecimento tipoDesaparecimento) {
        this.tipoDesaparecimento = tipoDesaparecimento;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    //Parcelable Implementation
    protected Alerta(Parcel in) {
        String[] data = new String[11];

        in.readStringArray(data);
        this.setId(Double.valueOf(data[0]));
        //this.setTipoAlerta(TipoAlerta Double.valueOf(data[1]));
        //this.setStatus(TipoStatusAlerta (Double.valueOf(data[2])));
        //this.setEmissor();

/*
        private double id;
        private TipoAlerta tipoAlerta;
        private TipoStatusAlerta status;
        private Usuario emissor;
        private Localizacao localizacao;
        private Date dataHoraAbertura;
        private Pessoa desaparecido;
        private Date ultimaAtualizacao;
        private Boolean encontrado;
        private TipoDesaparecimento tipoDesaparecimento;
        private List<Foto> fotos;
*/

    }

    public Alerta(){
        this(TipoAlerta.ALERTA_LOCAL, TipoDesaparecimento.PERDIDO, "", "", (short) -1);
    }

    public Alerta(TipoAlerta tipoAlerta, TipoDesaparecimento tipoDesaparecimento, String nomeDesaparecido, String sobrenomeDesaparecido, short idadeDesaparecido){
        this.fotos = new ArrayList<>();
        this.desaparecido = new Pessoa(nomeDesaparecido, sobrenomeDesaparecido, idadeDesaparecido);
        this.emissor = new Usuario();
        this.localizacao = new Localizacao();
        this.tipoAlerta = tipoAlerta;
        this.tipoDesaparecimento = tipoDesaparecimento;
        this.dataHoraAbertura = new Date();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Alerta> CREATOR = new Creator<Alerta>() {
        @Override
        public Alerta createFromParcel(Parcel in) {
            return new Alerta(in);
        }

        @Override
        public Alerta[] newArray(int size) {
            return new Alerta[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        Alerta alerta = (Alerta)obj;
        return (alerta.getId() == this.getId());
    }
}
