package com.mycompany.universidadeamazonia;


public class Aluno {
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

}
