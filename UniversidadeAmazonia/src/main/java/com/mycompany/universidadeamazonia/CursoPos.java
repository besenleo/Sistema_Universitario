package com.mycompany.universidadeamazonia;

public class CursoPos extends Curso implements Comparable<CursoPos>{
    
    public CursoPos(String nome, int anoCurso){
        this.nivel = nivel = "POS_GRADUACAO";
        this.nome = nome.toUpperCase();
        this.setAnoCurso(anoCurso);
    }
    
    @Override
    public int compareTo(CursoPos outro) {
        
        if(!(getAnoCurso() == outro.getAnoCurso())) {
            return getNome().compareTo(outro.getNome());
	}
        
        if(!getNivel().equals(outro.getNivel())) {
            return getNivel().compareTo(outro.getNivel());
	}
        
        if(!getNome().equals(outro.getNome())) {
            return getNome().compareTo(outro.getNome());
	}
        	
	return 0;
    }
    
    @Override
    public boolean equals(Object outro) {
		
	if(this == outro) {
            return true;
        }
        
        if(outro == null) {
            return false;
        }
        
        if( ! (outro instanceof CursoPos) ){
            return false;
        }
        
	CursoPos outroCurso = (CursoPos)outro;
        
        if(! (this.getAnoCurso() == outroCurso.getAnoCurso()) ){
            return false;
        }
        
	if(! this.getNome().equals(outroCurso.getNome())){
            return false;
        }
        
        if(! this.getNivel().equals(outroCurso.getNivel())){
            return false;
        }
        
	return true;
    }
}
