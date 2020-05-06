package com.mycompany.universidadeamazonia;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;


//Objetivo dessa classe é definir varias imutaveis de path para ser utilizadas 
//durante o codigo e definir um metodo que garanta a existencia dos arquivos 
//e pasta do projeto
public abstract class InitCSV {
    
    private final Path source = Paths.get(System.getProperty("user.dir"));
    private final Path parentSource = source.getParent();
    
    protected String InitCSVFiles() throws IOException{
        //Path da pasta DB
        String DBPath = parentSource.toString().concat("/DB");
        //Instanciando um objeto file com o path da onde deve ser o DB
        File diretorioDB = new File(DBPath);
        // Se o diretorio DB, que armazena os CSV, nao existir ele ira cria-lo
        if (!diretorioDB.exists()){
            diretorioDB.mkdir();
        }
        //Instanciando um objeto file do alunos.csv
        File alunosCSV = new File(DBPath + "/" + "alunos.csv");
        // Se o alunos.csv nao existir ele ira cria-lo
        if (!alunosCSV.exists()){
            try{
                alunosCSV.createNewFile();
            }catch(FileAlreadyExistsException ex){
                System.out.println("Arquivo alunos.csv já existe!");
            }
        }
        //Instanciando um objeto file do cursos.csv
        File cursosCSV = new File(DBPath + "/" + "cursos.csv");
        // Se o cursos.csv nao existir ele ira cria-lo
        if (!cursosCSV.exists()){
            try{
                cursosCSV.createNewFile();
            }catch(FileAlreadyExistsException ex){
                System.out.println("Arquivo cursos já existe!");
            }
        }
        return DBPath;
    }

    public Path getSource() {
        return source;
    }

    public Path getParentSource() {
        return parentSource;
    }
}
