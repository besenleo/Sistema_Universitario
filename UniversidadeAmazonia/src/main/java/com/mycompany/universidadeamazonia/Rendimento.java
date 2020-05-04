package com.mycompany.universidadeamazonia;

public class Rendimento {
    Aluno aluno;
    Curso curso;
    Notas notas;
    Notas media;
    boolean aprovado;
    
    //o parametro aluno vai ser mudado para um id
    //o parametro curso vai ser mudado para nome, nivel e ano
    public Rendimento(Aluno aluno, Curso curso, double notaNP1, double notaNP2, double notaRep, double notaExam){
        //funcao que recebe id e acha os parametros no csv e e retorna um objeto
        this.aluno = aluno;
        //funcao que recebe nome, nivel e ano e acha os parametros no csv e retorna um objeto
        this.curso = curso;
        
        Notas rendimento = new Notas(notaNP1, notaNP2, notaRep, notaExam);
        this.notas = rendimento;
        
        Notas media = new Notas(calcularMedia(notaNP1, notaNP2, notaRep, notaExam, curso));
        this.media = media;
        
    }
    
    private double calcularMedia(double notaNP1, double notaNP2, 
                                   double notaRep, double notaExam, 
                                   Curso curso){
        double mediaInicial;
        
        //Substitui o valor da NP1 ou NP2 caso o valor da Reposição for maior
        if(notaNP1 < notaRep || notaNP2 < notaRep){
            if (notaNP1 < notaNP2){
                notaNP1 = notaRep;
            }else{
                notaNP2 = notaRep;
            }
        }
        //Calculo media inicial
        mediaInicial = (notaNP1 + notaNP2)/2;      
        //Se o curso for uma GRADUACAO
        if (curso instanceof CursoGrad){
            //Identificar se a media incial é maior ou igual a 7
            if (mediaInicial >= 7){
                this.aprovado = true;
                return mediaInicial;
            //Caso nao seja ira precisar do exame, entao calcula-se a media final
            } else {
                double mediaFinal = (mediaInicial + notaExam)/2;
                // Caso maior que 5: aprovado
                if (mediaFinal > 5){
                    this.aprovado = true;
                    return mediaFinal;
                //senao reprovado.
                }else{
                    this.aprovado = false;
                    return mediaFinal;
                }
            }
        //Se o curso for uma POS-GRADUACAO
        }else if(curso instanceof CursoPos){
            //Identificar se a media incial é maior ou igual a 5
            if (mediaInicial >= 5){
                this.aprovado = true;
                return mediaInicial;
            //Caso nao seja ira precisar do exame, entao calcula-se a media final
            } else {
                double mediaFinal = (mediaInicial + notaExam)/2;
                // Caso maior que 5 aprovado...
                if (mediaFinal > 5){
                    this.aprovado = true;
                    return mediaFinal;
                //senao reprovado.
                }else{
                    this.aprovado = false;
                    return mediaFinal;
                }
            }
        //Caso nao seja nem gradução nem pos-gradução
        }else{
            throw new IllegalArgumentException("Curso não é uma gradução nem uma pós-gradução: " + curso.getClass().getName());
        }
    }
    
    public Notas getMedia() {
        return media;
    }

    public Curso getCurso() {
        return curso;
    }

    public Notas getNotas() {
        return notas;
    }

    public boolean isAprovado() {
        return aprovado;
    }    
}
