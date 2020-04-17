package com.mycompany.universidadeamazonia;


public class Aluno {
    private String id;
    private String nome;
    
    //Listar todos os alunos inscritos: para cada aluno deve ser impresso seu nome e id, somente
    //Incluir um novo aluno: deve ser pedido para o usuário informar o id e o nome do aluno.
    
    
    public Aluno(String id, String nome){
        if(id.length() == 7){
            this.id = id;
            this.nome = nome;
            //funcao que adiciona no csv
        }else{
            throw new IllegalArgumentException("O nome do aluno e seu id devem ser uma String. O id deve conter 7 caracteres");
        }
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
