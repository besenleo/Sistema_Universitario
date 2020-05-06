package com.mycompany.universidadeamazonia;

public abstract class Curso implements Comparable<Curso>{
    protected String nome;
    protected int anoCurso;
    protected String nivel;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCurso() {
        return anoCurso;
    }

    public void setAnoCurso(int anoCurso) {
        // ve se o ano tem 4 caracteres
        if ((int) (Math.log10(anoCurso) + 1) == 4){
            this.anoCurso = anoCurso;
        }else{
            throw new IllegalArgumentException("A quantidade de carecteres para o ano deve ser igual a 4. Ex: 2019");
        }
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public String nomeDoArquivo(){
        return "/" + this.getNome() + "_" + this.getNivel() + "_" + this.getAnoCurso() + ".csv";
    }

    @Override
    public int compareTo(Curso outro){
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
        
        if( ! (outro instanceof Curso) ){
            return false;
        }
        
	Curso outroCurso = (Curso)outro;
        
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
