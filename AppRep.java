package com.example.julia.meuappmain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class AppRep {
    AppRepositorio app;
    App ap;
    DBHelper helper;
    public AppRep(Context context){
        helper = new DBHelper(context);
    }
    public long inserir (AppRepositorio app){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", app.nomeApp);
        values.put("intent", String.valueOf(app.intent));
        long result = db.insert("aplicativos",  null, values);
        db.close();
        return result;
    }
    public List<App> buscarTodosFuncionarios(String resultadoReconhecimento) {
        SQLiteDatabase db = helper.getReadableDatabase();
        String[] columns = {"intent"};
        String selection = "nome = ?";
        String[] selectionArgs = {resultadoReconhecimento};
        Cursor cursor = db.query(DBHelper.TABELA_APP, columns, selection, selectionArgs, null, null, null);

        List<App> apps = new ArrayList<>();
        if(cursor.moveToFirst()) {
            String intent = cursor.getString(0);
            apps.add(ap);
        }
        cursor.close();
        db.close();
        return apps;
    }
}
