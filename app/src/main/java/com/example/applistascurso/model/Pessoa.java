package com.example.applistascurso.model;

public class Pessoa {
    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefoneContato;

    public Pessoa() {

    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                " Nome='" + primeiroNome + '\'' +
                '}';
    }
}
