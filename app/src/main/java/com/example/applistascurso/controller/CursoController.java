package com.example.applistascurso.controller;

import com.example.applistascurso.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos() {

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Android"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("JavaScript"));
        listCursos.add(new Curso("PHP"));

        return listCursos;
    }
    public ArrayList<String> dadosParaSpinner() {
        ArrayList<String> dados = new ArrayList<String>();

        for(int i = 0; i < getListaDeCursos().size(); i++) {
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
        }

        return dados;
    }
}
