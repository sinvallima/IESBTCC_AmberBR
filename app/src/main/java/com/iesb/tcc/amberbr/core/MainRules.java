package com.iesb.tcc.amberbr.core;

import android.content.Context;
import android.content.Intent;

import com.facebook.CallbackManager;
import com.iesb.tcc.amberbr.entity.Alerta;
import com.iesb.tcc.amberbr.entity.Configuracao;
import com.iesb.tcc.amberbr.entity.Usuario;
import com.iesb.tcc.amberbr.exceptions.GenericBusinessException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Criado por Sinvas em 11/02/2017.
 */

public class MainRules implements Serializable, CallbackManager {

    private Context context;
    private Configuracao configuracao;
    private boolean bLogado = false;
    private Usuario usuario;
    private boolean bDadosCarregados = false;
    private List<Alerta> alertasRecentes = new ArrayList<>();
    private List<Alerta> alertasEncerrados= new ArrayList<>();

    public MainRules(Context context) throws GenericBusinessException {

        this.context = context;
        this.usuario = new Usuario();
        this.alertasRecentes = new ArrayList<>();
        this.alertasEncerrados = new ArrayList<>();

        ConfiguracaoDAO configuracaoDAO = new ConfiguracaoDAO(this.context);
        this.setConfiguracao(configuracaoDAO.carregaConfiguracoes());
        this.bDadosCarregados = true;


    }


    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public boolean isbLogado() {
        return bLogado;
    }

    public void setbLogado(boolean bLogado) {
        this.bLogado = bLogado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isbDadosCarregados() {
        return bDadosCarregados;
    }

    public void setbDadosCarregados(boolean bDadosCarregados) {
        this.bDadosCarregados = bDadosCarregados;
    }

    public List<Alerta> getAlertasRecentes() {
        return alertasRecentes;
    }

    public void setAlertasRecentes(List<Alerta> alertasRecentes) {
        this.alertasRecentes = alertasRecentes;
    }

    public List<Alerta> getAlertasEncerrados() {
        return alertasEncerrados;
    }

    public void setAlertasEncerrados(List<Alerta> alertasEncerrados) {
        this.alertasEncerrados = alertasEncerrados;
    }

    @Override
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return false;
        //ver se tem que colocar algum codigo aqui (SBL)
    }
}
