package com.mycompany.universidadeamazonia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.FileAlreadyExistsException;

public class EscreverCSV extends InitCSV{
    private LerCSV leitura = new LerCSV(); // Instancia a classe de leitura
    
    public void adicionarAluno(Aluno aluno) {
    // Esse metodo é responsavel por adicionar um novo aluno no alunos.csv
        try{
            //Verifica se o arquivos foram criados e retorna o path da pasta dos arquivos
            String pathDB = this.InitCSVFiles();
            //Verifica se o aluno ja existe
            boolean jaExiste = this.leitura.verificarAlunoJaExiste(aluno);
            if (jaExiste == false){
                //Instancia um FileWriter dentro de um buffer e seta o append do FileWriters igual a true
                BufferedWriter writer = new BufferedWriter(new FileWriter((pathDB + "/alunos.csv"), true));     
                writer.write(aluno.getId()+ ";" + aluno.getNome() + "\n");
                writer.close(); //fecha o arquivo apos escrever
            }else{
                System.out.println("Aluno ja foi cadastrado!");
            }
        }catch (Exception ex){
            System.err.println("Nao foi possivel adicionar o aluno! " + ex);
        }   
    } 
    
    public void adicionarCurso(Curso curso) {
    /* Esse metodo é responsavel por adicionar um novo curso de Gradução no 
    cursos.csv e criar seu respectivo csv para armazenar os rendimentos */
        try{
            //Verifica se o arquivos foram criados e retorna o path da pasta dos arquivos
            String pathDB = this.InitCSVFiles();
            //Verifica se o curso ja existe
            boolean jaExiste = this.leitura.verificarCursoJaExiste(curso);
            if (jaExiste == false){
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
            }else{
                System.out.println("Curso ja foi cadastrado!");
            }
        }catch (Exception ex){
            System.err.println("Nao foi possivel adicionar o curso! " + ex);
        }   
    }
   
    
    
}
