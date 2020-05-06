package com.mycompany.universidadeamazonia;


public class Aluno implements Comparable<Aluno>{
    private String id;
    private String nome;    
    
    public Aluno(String id, String nome){
            this.id = id;
            this.nome = nome;
    }
    
    public String getId(){
           return this.id;
    }
    
    public void  setId (String i){
          this.id = i;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Aluno outro) {
        
//        if(!getNome().equals(outro.getNome())) {
//            return getNome().compareTo(outro.getNome());
//	}
        
        if(!getId().equals(outro.getId())) {
            return getId().compareTo(outro.getId());
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
        
	if( ! (outro instanceof Aluno) ){
            return false;
        }
        
	Aluno outroAluno = (Aluno)outro;
        
        //As pessoas podem ter o mesmo nome desde que nao tenham ids iguais
        if(! (this.getId() == outroAluno.getId()) ){
            return false;
        }
        
	return true;
    }

}
