package com.IgorDev.applistavip.model;

//Declaração de uma classe do tipo pessoa
//Aqui dentro será incluido atributos e métodos
//referente à pessoa. Por exemplo: nome, sobrenome,
//idade/altura/peso etc.
public class Pessoa {
    //construtor
    // Atributos - Objetos, Molde, Modelo, Templete
    // Métodos de Acesso - Gets and Sets
    private String primeiroNome;
    private String Sobrenome;
    private String cursoDesejado;
    private String telefoneContato;

    public Pessoa(){}

    public String getPrimeiroNome(){
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome){
        this.primeiroNome = primeiroNome;
    }
    public String getSobrenome(){
        return Sobrenome;
    }
    public void setSobrenome(String Sobrenome){
        this.Sobrenome = Sobrenome;
    }
    public String getCursoDesejado(){
        return cursoDesejado;
    }
    public void setCursoDesejado(String Curso){
        this.cursoDesejado = Curso;
    }
    public String getTelefone(){
        return telefoneContato;
    }
    public void setTelefone(String Telefone){
        this.telefoneContato = Telefone;
    }
}
