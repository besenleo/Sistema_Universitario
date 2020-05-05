package com.mycompany.universidadeamazonia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileAlreadyExistsException;

public class EscreverCSV extends InitCSV{
    
    public void adicionarAluno(Aluno aluno) {
    // Esse metodo é responsavel por adicionar um novo aluno no alunos.csv
        try{
            //TODO: VERIFICAR SE O ALUNO JA NAO EXISTE ANTES DE ADICIONAR (CRIAR FUNCAO QUE LE TUDO E FAZER UM FOR PARA VER SE JA EXISTE)
            //Verifica se o arquivos foram criados e retorna o path da pasta dos arquivos
            String pathDB = this.InitCSVFiles();
            //Instancia um FileWriter dentro de um buffer e seta o append do FileWriters igual a true
            BufferedWriter writer = new BufferedWriter(new FileWriter((pathDB + "/alunos.csv"), true));     
            writer.write(aluno.getId()+ ";" + aluno.getNome() + "\n");
            writer.close(); //fecha o arquivo apos escrever
        }catch (Exception ex){
            System.err.println("Nao foi possivel adicionar o aluno! " + ex);
        }   
    } 
    
    public void adicionarCurso(CursoGrad curso) {
    /* Esse metodo é responsavel por adicionar um novo curso de Gradução no 
    cursos.csv e criar seu respectivo csv para armazenar os rendimentos */
        try{
            //TODO: VERIFICAR SE O CURSO JA NAO EXISTE ANTES DE ADICIONAR (CRIAR FUNCAO QUE LE TUDO E FAZER UM FOR PARA VER SE JA EXISTE)
            //Verifica se o arquivos foram criados e retorna o path da pasta dos arquivos
            String pathDB = this.InitCSVFiles();
            //Instancia um FileWriter dentro de um buffer e seta o append do FileWriters igual a true
            BufferedWriter writer = new BufferedWriter(new FileWriter((pathDB + "/cursos.csv"), true));     
            writer.write(curso.getNome()+ ";" + curso.getNivel() + ";" + curso.getAnoCurso() + "\n");
            writer.close(); //fecha o arquivo apos escrever
            //Instanciando um objeto file do curso
            File cursoCSV = new File(pathDB + "/" + curso.getNome()+"_"+curso.getNivel()+"_"+curso.getAnoCurso()+".csv");
            // Se o csv do curso nao existir ele ira cria-lo
            if (!cursoCSV.exists()){
                try{
                    cursoCSV.createNewFile();
                }catch(FileAlreadyExistsException ex){
                    System.out.println("Arquivo do curso já existe!");
                }
            }
        }catch (Exception ex){
            System.err.println("Nao foi possivel adicionar o curso! " + ex);
        }   
    }
    
    public void adicionarCurso(CursoPos curso) {
    /* Esse metodo é responsavel por adicionar um novo curso de Pos-Graduação no 
    cursos.csv e criar seu respectivo csv para armazenar os rendimentos */
        try{
            //TODO: VERIFICAR SE O CURSO JA NAO EXISTE ANTES DE ADICIONAR (CRIAR FUNCAO QUE LE TUDO E FAZER UM FOR PARA VER SE JA EXISTE)
            //Verifica se o arquivos foram criados e retorna o path da pasta dos arquivos
            String pathDB = this.InitCSVFiles();
            //Instancia um FileWriter dentro de um buffer e seta o append do FileWriters igual a true
            BufferedWriter writer = new BufferedWriter(new FileWriter((pathDB + "/cursos.csv"), true));     
            writer.write(curso.getNome()+ ";" + curso.getNivel() + ";" + curso.getAnoCurso() + "\n");
            writer.close(); //fecha o arquivo apos escrever
            //Instanciando um objeto file do curso
            File cursoCSV = new File(pathDB + "/" + curso.getNome()+"_"+curso.getNivel()+"_"+curso.getAnoCurso()+".csv");
            // Se o csv do curso nao existir ele ira cria-lo
            if (!cursoCSV.exists()){
                try{
                    cursoCSV.createNewFile();
                }catch(FileAlreadyExistsException ex){
                    System.out.println("Arquivo do curso já existe!");
                }
            }
        }catch (Exception ex){
            System.err.println("Nao foi possivel adicionar o curso! " + ex);
        }   
    }
}
