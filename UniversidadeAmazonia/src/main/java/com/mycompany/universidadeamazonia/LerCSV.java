package com.mycompany.universidadeamazonia;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LerCSV extends InitCSV{
    
    public ArrayList listarTodosAlunos() {
    /* Metodo responsavel por listar todos os alunos. Retorna um ArrayList de
    objetos Aluno*/    
        
        try {
            String linha;
            String delimitador = ";";
            String pathDB = this.InitCSVFiles();
            ArrayList<Aluno> alunos = new ArrayList<>();
            
            BufferedReader br = Files.newBufferedReader(Paths.get(pathDB + "/alunos.csv"));

            while ((linha = br.readLine()) != null) {
                String[] itemDaLinha = linha.split(delimitador);
                // Esse if é para caso tenha linhas em branco no CSV
                if (!linha.equals("")){
                    Aluno aluno = new Aluno(itemDaLinha[0], itemDaLinha[1]);
                    alunos.add(aluno);
                }
            }
            br.close();
            return alunos;

        } catch (Exception ex) {
            System.err.println("Nao foi possivel listar os alunos! " + ex);
            return null;
        }     
    }
    
    public ArrayList listarTodosCursos() {
    /* Metodo responsavel por listar todos os cursos. Retorna um ArrayList de
    objetos Curso*/    
        
        try {
            String linha;
            String delimitador = ";";
            String pathDB = this.InitCSVFiles();
            ArrayList<Curso> cursos = new ArrayList<>();
            
            BufferedReader br = Files.newBufferedReader(Paths.get(pathDB + "/cursos.csv"));

            while ((linha = br.readLine()) != null) {
                String[] itemDaLinha = linha.split(delimitador);
                // Esse if é para caso tenha linhas em branco no CSV
                if (!linha.equals("") && itemDaLinha[1].equals("GRADUACAO")){
                    CursoGrad curso = new CursoGrad(itemDaLinha[0], Integer.parseInt(itemDaLinha[2]));
                    cursos.add(curso);
                }
                if (!linha.equals("") && itemDaLinha[1].equals("POS_GRADUACAO")){
                    CursoPos curso = new CursoPos(itemDaLinha[0], Integer.parseInt(itemDaLinha[2]));
                    cursos.add(curso);
                }
            }
            br.close();
            return cursos;

        } catch (Exception ex) {
            System.err.println("Nao foi possivel listar os alunos! " + ex);
            return null;
        }     
    }
    
}
