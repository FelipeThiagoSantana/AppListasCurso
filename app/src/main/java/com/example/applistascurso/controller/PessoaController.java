package com.example.applistascurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.applistascurso.database.ListaCursosDB;
import com.example.applistascurso.model.Pessoa;
import com.example.applistascurso.view.MainActivity;

import java.util.List;

public class PessoaController extends ListaCursosDB {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        super(mainActivity);
        preferences = mainActivity.getSharedPreferences("NOME_PREFERENCES", 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {
        ContentValues dados = new ContentValues();

        listaVip.putString("primeroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        //listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();

        dados.put("nome", pessoa.getPrimeiroNome());
        dados.put("sobrenome", pessoa.getSobrenome());
        dados.put("telefoneContato", pessoa.getTelefoneContato());
        dados.put("cursoDesejado", pessoa.getCursoDesejado());

        salvarObjeto("Pessoas", dados);


        Log.d("PessoaController", "Salvando pessoa: " + pessoa.toString());

    }
    public void atualizarNome(String nome) {
        ContentValues dados = new ContentValues();
        listaVip.putString("primeroNome", nome);
        listaVip.apply();
        dados.put("nome", nome);
        atualizarObjeto("Pessoas", nome, dados);
    }



    //TODO: Listar pessoas
    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }

    public List<Pessoa> getListaDePessoas() {
        return listarPessoas();
    }



    //Todo: Alterar pessoa
    public void alterar(Pessoa pessoa) {
        ContentValues dados = new ContentValues();


        dados.put("id", pessoa.getIdPessoa());
        pessoa.setPrimeiroNome(preferences.getString("primeroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        alterarObjeto("Pessoas", dados);
    }

    public void deletar(int id) {
        deletarObjeto("Pessoas", id);

    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();

    }

}
