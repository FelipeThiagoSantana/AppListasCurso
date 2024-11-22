package com.example.applistascurso.controller;

import com.example.applistascurso.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    public List listCursos;

    public List getListaCursos() {

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());
        listCursos.add(new Curso());

        return listCursos;
    }
}
