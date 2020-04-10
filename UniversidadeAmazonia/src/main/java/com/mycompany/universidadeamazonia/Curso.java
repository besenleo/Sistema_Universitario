package com.mycompany.universidadeamazonia;

public class Curso {
    private String nome;
    private nivelCurso nivelCurso;
    private int anoCurso;

    
    public Curso(String nome, nivelCurso nivelCurso, int anoCurso) {
        // como atribuir e usar Enum numa classe  rever get e setter
        if ((int) (Math.log10(anoCurso) + 1) == 4){
            this.nome = nome;
            //this.nivelCurso = nivelCurso; 
            this.anoCurso = anoCurso;
            System.out.println("O nome do curso e " + this.nome + ". o nivel e " + this.nivelCurso + ". O ano de inicio foi " + this.anoCurso);
        }else{
            throw new IllegalArgumentException("A quantidade de carecteres para o ano deve ser igual a 4. Ex: 2019");
        }
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public nivelCurso getNivel(){
        return this.nivelCurso;
    }
    
    public void setNivel(nivelCurso nivel){
        this.nivelCurso = nivel;
    }

    public int getAno(){
        return this.anoCurso;
    }
    
    public void setAno(int ano){
        this.anoCurso = ano;
    }
}
