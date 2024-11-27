package com.example.applistascurso.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.applistascurso.controller.CursoController;

public class ListaCursosDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "Pessoa.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public ListaCursosDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela = "CREATE TABLE Pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nome TEXT, "+
                "sobrenome TEXT, "+
                "telefoneContato TEXT, " +
                "cursoDesejado TEXT)";
        db.execSQL(sqlTabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
