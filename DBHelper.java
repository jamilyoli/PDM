package com.example.julia.meuappmain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NOME = "App_Banco";
    private static final int VERSAO = 1;

    public static final String TABELA_APP = "App";
    public static final String TABELA_ID_APP = "_id";
    public static final String TABELA_NOME_APP = "nome";
    public static final String TABELE_INTENT_APP = "intent";

    public DBHelper(Context context) {
        super(context, DB_NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+ TABELA_APP + "("+
                TABELA_ID_APP +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TABELA_NOME_APP +"TEXT NOT NULL," +
                TABELE_INTENT_APP+"TEXT NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_APP + ";";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
}
