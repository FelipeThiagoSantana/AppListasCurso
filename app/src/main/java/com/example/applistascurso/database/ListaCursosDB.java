package com.example.applistascurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.applistascurso.model.Pessoa;

import java.util.ArrayList;
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


    //Create DataBase
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

    //insert data into database
    public void salvarObjeto(String tabela,
                             ContentValues dados) {
        db.insert(tabela, null, dados);

    }
    //list data from database
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();


        Pessoa registro;

        String querySQL = "SELECT * FROM Pessoas";

        cursor = db.rawQuery(querySQL, null);

        if (cursor.moveToFirst()) {
            //TODO: Count SQL registers

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


    //Update data from database
    public void atualizarObjeto(String tabela, String nomeColuna,
                             ContentValues dados) {
        db.insert(tabela, nomeColuna, dados);
    }

    public void  alterarObjeto(String tabela,
                                     ContentValues dados) {
        //
        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id = ?",
                new String[]{String.valueOf(id)});
    }

    //Delete data from database
    public void deletarObjeto(String tabela,
                              int dados) {
        //
        int id = dados.getAsInteger("id");
        db.delete(tabela, "id = ?",
                new String[]{String.valueOf(id)});
    }

}