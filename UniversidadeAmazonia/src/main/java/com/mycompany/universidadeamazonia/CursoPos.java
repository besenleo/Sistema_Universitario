package com.mycompany.universidadeamazonia;

public class CursoPos extends Curso{
    private final String nivel = "pos_graduacao";
    
    public CursoPos(String nome, int anoCurso){
        this.nome = nome;
        this.setAnoCurso(anoCurso);
    }

    public String getNivel() {
        return nivel;
    }
}
