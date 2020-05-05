package com.mycompany.universidadeamazonia;

public abstract class Curso {
    protected String nome;
    protected int anoCurso;
    protected String nivel;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCurso() {
        return anoCurso;
    }

    public void setAnoCurso(int anoCurso) {
        // ve se o ano tem 4 caracteres
        if ((int) (Math.log10(anoCurso) + 1) == 4){
            this.anoCurso = anoCurso;
        }else{
            throw new IllegalArgumentException("A quantidade de carecteres para o ano deve ser igual a 4. Ex: 2019");
        }
    }
    
    public String getNivel() {
        return nivel;
    }
    
    public String nomeDoArquivo(){
        return "/" + this.getNome() + "_" + this.getNivel() + "_" + this.getAnoCurso() + ".csv";
    }
}
