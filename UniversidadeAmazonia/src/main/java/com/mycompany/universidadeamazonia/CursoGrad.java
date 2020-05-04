package com.mycompany.universidadeamazonia;

public class CursoGrad extends Curso{
    private final String nivel = "graduacao";
    
    public CursoGrad(String nome, int anoCurso){
        this.nome = nome;
        this.setAnoCurso(anoCurso);
    }

    public String getNivel() {
        return nivel;
    }
}
