package com.mycompany.universidadeamazonia;

public class CursoPos extends Curso{
    private final String nivel = "POS_GRADUACAO";
    
    public CursoPos(String nome, int anoCurso){
        this.nome = nome.toUpperCase();
        this.setAnoCurso(anoCurso);
    }

    public String getNivel() {
        return nivel;
    }
}
