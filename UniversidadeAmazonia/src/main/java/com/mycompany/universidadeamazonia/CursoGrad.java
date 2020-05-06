package com.mycompany.universidadeamazonia;

public class CursoGrad extends Curso{
    
    public CursoGrad(String nome, int anoCurso){
        this.nivel = "GRADUACAO";
        this.nome = nome.toUpperCase();
        this.setAnoCurso(anoCurso);
    }
}
