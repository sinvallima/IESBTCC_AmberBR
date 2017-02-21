package com.iesb.tcc.amberbr.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Criado por Sinvas em 07/02/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //implementação de Singleton desta classe
    private static DatabaseHelper instance = null;

    public static DatabaseHelper getInstance(Context context){
        if (instance == null){
            instance = new DatabaseHelper(context);
        }

        return instance;
    }

    private static final String BANCO_DADOS = "MySQLiteDB";
    private static final int VERSAO_DB = 1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO_DB);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criacao das tabelas

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario (" +
                    "id_facebook TEXT PRIMARY KEY, " +
                    "nome TEXT, " +
                    "sobrenome TEXT, " +
                    "telefone TEXT, " +
                    "email TEXT);");

            db.execSQL("CREATE TABLE IF NOT EXISTS alerta (" +
                    "id LONG PRIMARY KEY, " +
                    "tipo_alerta INTEGER, " +
                    "status INTEGER, " +
                    "id_emissor TEXT, " +
                    "latitude REAL, " +
                    "longitude REAL, " +
                    "nome_local TEXT, " +
                    "data TEXT, " +
                    "hora LONG, " +
                    "nome_desaparecido TEXT, " +
                    "sobrenome_desaparecido TEXT, " +
                    "idade_desaparecido INTEGER, " +
                    "hora_ult_atualizacao LONG, " +
                    "encontrado BOOLEAN, " +
                    "tipo_desaparecimento INTEGER);");

            db.execSQL("CREATE TABLE IF NOT EXISTS avistamento (" +
                    "id LONG, " +
                    "id_alerta LONG, " +
                    "id_emissor TEXT, " +
                    "latitude REAL, " +
                    "longitude REAL, " +
                    "nome_local TEXT, " +
                    "data TEXT, " +
                    "hora LONG, " +
                    "descricao TEXT," +
                    "PRIMARY KEY (id, id_alerta));");

            db.execSQL("CREATE TABLE IF NOT EXISTS foto_avistamento (" +
                    "id LONG, " +
                    "id_alerta LONG, " +
                    "id_avistamento LONG, " +
                    "imagem TEXT," +
                    "PRIMARY KEY (id, id_alerta, id_avistamento));");

            db.execSQL("CREATE TABLE IF NOT EXISTS foto_alerta (" +
                    "id LONG, " +
                    "id_alerta LONG, " +
                    "imagem TEXT," +
                    "PRIMARY KEY (id, id_alerta));");

            db.execSQL("CREATE TABLE IF NOT EXISTS configuracao (_id INTEGER PRIMARY KEY, " +
                    "raio_alerta_local INTEGER, " +
                    "raio_alerta_policial INTEGER);");

            carregaConfiguracoesIniciais(db);



        }catch (Exception e){
            Toast.makeText(this.context, "Ocorreu um erro ao criar estruturas de dados. " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < VERSAO_DB) {
            db.execSQL("DROP TABLE IF EXISTS usuario");
            db.execSQL("DROP TABLE IF EXISTS alerta");
            db.execSQL("DROP TABLE IF EXISTS avistamento");
            db.execSQL("DROP TABLE IF EXISTS foto_avistamento");
            db.execSQL("DROP TABLE IF EXISTS foto_alerta");
            db.execSQL("DROP TABLE IF EXISTS configuracao");
            onCreate(db);
        }

    }

    private void carregaConfiguracoesIniciais(SQLiteDatabase db){

        Cursor cursorConfiguracao = null;
        long result = 0;

        try {

            cursorConfiguracao = db.rawQuery("SELECT _id, " +
                    "raio_alerta_local, " +
                    "raio_alerta_policial " +
                    "FROM configuracao WHERE _id = 1", null);
            cursorConfiguracao.moveToFirst();

            if (cursorConfiguracao.getCount() == 0){
                //Já que não existe regitro de configuracao, cria um com os valores padrão

                ContentValues value = new ContentValues();

                value.put("raio_alerta_local", MainDefaultValues.RAIO_MIN_ALERTA_LOCAL_USU_COMUM);
                value.put("raio_alerta_policial", MainDefaultValues.RAIO_MIN_ALERTA_POLICIAL_USU_COMUM);

                result = db.insert("configuracao", null, value);

                if (result == -1) {
                    throw new Exception("Erro ao gravar configurações iniciais!");
                }
            }
        }catch (Exception ex){
            result = result +1;
        }finally {
            if(cursorConfiguracao != null){ cursorConfiguracao.close();}
        }
    }}
