package com.mycompany.universidadeamazonia;

public class CursoPos extends Curso{
    
    public CursoPos(String nome, int anoCurso){
        this.nivel = "POS_GRADUACAO";
        this.nome = nome.toUpperCase();
        this.setAnoCurso(anoCurso);
    }
}    
