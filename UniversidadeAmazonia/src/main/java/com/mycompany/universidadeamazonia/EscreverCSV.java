package com.mycompany.universidadeamazonia;

import java.io.IOException;

public class EscreverCSV extends InitCSV{
    
    public void adicionarAluno(Aluno aluno) {
        try{
            this.InitCSVFiles();
            //implementar adicionar o aluno no CSV
        }catch (IOException ex){
            System.err.println("Nao foi possivel adicionar o aluno! " + ex);
        }   
    } 
}
