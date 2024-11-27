package com.example.applistascurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.applistascurso.controller.CursoController;
import com.example.applistascurso.model.Pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListaCursosDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "Pessoa.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public ListaCursosDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela = "CREATE TABLE Pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "sobrenome TEXT, " +
                "telefoneContato TEXT, " +
                "cursoDesejado TEXT)";
        db.execSQL(sqlTabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void salvarObjeto(String tabela,
                             ContentValues dados) {
        db.insert(tabela, null, dados);


    }

    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();


        Pessoa registro;

        String querySQL = "SELECT * FROM Pessoas";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Pessoa();
                registro.setIdPessoa(cursor.getInt(0));
                registro.setPrimeiroNome(cursor.getString(1));
                registro.setSobrenome(cursor.getString(2));
                registro.setTelefoneContato(cursor.getString(3));
                registro.setCursoDesejado(cursor.getString(4));


                pessoas.add(registro);

            } while (cursor.moveToNext());
        } else{
            return null;
        }

        return pessoas;

    }

    public void atualizarObjeto(String tabela, String nomeColuna,
                             ContentValues dados) {
        db.insert(tabela, nomeColuna, dados);
    }








}