package com.iesb.tcc.amberbr.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.iesb.tcc.amberbr.entity.Configuracao;
import com.iesb.tcc.amberbr.exceptions.GenericDatabaseException;

/**
 * Criado por Sinvas em 08/02/2017.
 */

public class ConfiguracaoDAO {

    private Context context;
    private SQLiteDatabase db;

    public ConfiguracaoDAO(Context context){

        this.context = context;
        db = DatabaseHelper.getInstance(this.context).getReadableDatabase();
    }

    public Configuracao carregaConfiguracoes(){
        Configuracao retorno = new Configuracao();

        //SQLiteDatabase db = DatabaseHelper.getInstance(context).getReadableDatabase();

        Cursor cursorConfiguracao = null;
        long result = 0;

        try {
            cursorConfiguracao = db.rawQuery("SELECT _id, " +
                    "raio_alerta_local, " +
                    "raio_alerta_policial " +
                    "FROM configuracao WHERE _id = 1", null);

            cursorConfiguracao.moveToFirst();

            if (cursorConfiguracao.getCount() >= 1){
                //Recupera sempre o primeiro registro (devia ter só um mesmo)
                retorno.setRaioAlertaLocal(cursorConfiguracao.getInt(1));
                retorno.setRaioAlertaPolicial(cursorConfiguracao.getInt(2));
            }
        }catch (Exception ex){
            retorno = new Configuracao();
            retorno.setRaioAlertaLocal(MainDefaultValues.RAIO_MIN_ALERTA_LOCAL_USU_COMUM);
            retorno.setRaioAlertaPolicial(MainDefaultValues.RAIO_MIN_ALERTA_POLICIAL_USU_COMUM);

        }finally {
            if(cursorConfiguracao != null){ cursorConfiguracao.close();}
        }

        return retorno;
    }

    public void gravaConfiguracao(Configuracao conf) throws GenericDatabaseException {

        //SQLiteDatabase db = this.getWritableDatabase();
        long result;

        try {

            ContentValues value = new ContentValues();

            value.put("raio_alerta_local", conf.getRaioAlertaLocal());
            value.put("raio_alerta_policial", conf.getRaioAlertaPolicial());

            result =  db.update("configuracao", value, "_id = 1", null );

            if (result == -1) {
                throw new Exception("Erro ao gravar configuração!");
            }

        }catch (Exception ex){
            throw new GenericDatabaseException(ex.getMessage());
        }
    }
}
