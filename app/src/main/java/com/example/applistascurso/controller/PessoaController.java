package com.example.applistascurso.controller;

import android.util.Log;

import com.example.applistascurso.model.Pessoa;

public class PessoaController {

    public void salvar(Pessoa pessoa) {
        Log.d("PessoaController", "Salvando pessoa: " + pessoa.toString());

    }
}
