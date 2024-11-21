package com.example.applistascurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.applistascurso.model.Pessoa;
import com.example.applistascurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences("NOME_PREFERENCES", 0);
        listaVip = preferences.edit();
    }

    public void salvar(Pessoa pessoa) {

        listaVip.putString("primeroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();

        Log.d("PessoaController", "Salvando pessoa: " + pessoa.toString());

    }


    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeroNome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();

    }
}
