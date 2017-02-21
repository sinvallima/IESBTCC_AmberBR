package com.iesb.tcc.amberbr.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Criado por Sinvas em 08/02/2017.
 */

public class UsuarioDAO {

    private Context context;
    private SQLiteDatabase db;

    public UsuarioDAO(Context context){

        this.context = context;
        db = DatabaseHelper.getInstance(this.context).getReadableDatabase();
    }

}
