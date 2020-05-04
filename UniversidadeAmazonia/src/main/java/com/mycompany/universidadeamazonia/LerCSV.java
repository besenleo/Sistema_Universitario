package com.mycompany.universidadeamazonia;

import java.io.IOException;

public class LerCSV extends InitCSV{
    
    public void listarAluno(Aluno aluno) {
        try{
            this.InitCSVFiles();
            //implementar listar o histórico de um determinado aluno
        }catch (IOException ex){
            System.err.println("Nao foi possivel adicionar o aluno! " + ex);
        }   
    }
    
}
