package com.iesb.tcc.amberbr.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Criado por Sinvas em 08/02/2017.
 */

public class FotoAlertaDAO {

    private Context context;
    private SQLiteDatabase db;

    public FotoAlertaDAO(Context context){

        this.context = context;
        db = DatabaseHelper.getInstance(this.context).getReadableDatabase();
    }

}
