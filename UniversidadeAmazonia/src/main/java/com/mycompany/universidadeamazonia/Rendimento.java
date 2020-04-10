package com.mycompany.universidadeamazonia;

public class Rendimento {
    Aluno aluno;
    Curso curso;
    NotaNP1 notaNP1;
    NotaNP2 notaNP2;
    NotaRep notaRep;
    NotaExame notaExame;
    boolean aprovado;
    NotaMedia media;
    
    // Talvez o rendimento receba todos os parametros de todas as classes abaixo 
    // para que seja validado (e talvez instanciado) e lido\
    // VAMOS PRECISAR DE:
    // de uma alguma coisa que le os inputs do usuario, vai no CSV e 
    // acha os valores e instancia um objeto para aquele cara. Isso vai ser usado abaixo.
    public Rendimento(Aluno aluno, Curso curso, NotaNP1 notaNP1, 
                      NotaNP2 notaNP2, NotaRep notaRep, NotaExame notaExame){
        //funcao que recebe e acha os parametros no csv
        //Aluno a = new Aluno(parametros_da_funcao_acima);
        this.aluno = aluno;
        //funcao que recebe e acha os parametros no csv
        //Curso c = new Curso(parametros_da_funcao_acima);
        this.curso = curso;
        //NotaNP1 np1 = new NotaNP1(notaNP1);
        //this.notaNP1.setNota(notaNP1);
        this.notaNP1 = notaNP1;
        this.notaNP2 = notaNP2;
        this.notaRep = notaRep;
        this.notaExame = notaExame;
        this.media = calcularMedia(notaNP1, notaNP2, notaRep, notaExame, curso); // nao seria melhor que fosse um double?
        
    }
    
    // tem que ser private ou nao? 
    public NotaMedia calcularMedia(NotaNP1 notaNP1, NotaNP2 notaNP2, 
                                   NotaRep notaRep, NotaExame notaExame, 
                                   Curso curso){
        double mediaInicial;
        double NP1 = notaNP1.getNota();
        double NP2 = notaNP2.getNota();
        double rep = notaRep.getNota();
        double exame = notaExame.getNota();
        
        //Substitui o valor da NP1 ou NP2 caso o valor da Reposição for maior
        if(NP1 < rep || NP2 < rep){
            if (NP1 < NP2){
                NP1 = rep;
            }else{
                NP2 = rep;
            }
        }
        //Calculo media inicial
        mediaInicial = (NP1 + NP2)/2;      
        //Se o curso for uma GRADUACAO
        if (curso.getNivel() == nivelCurso.GRADUACAO){
            //Identificar se a media incial é maior ou igual a 7
            if (mediaInicial >= 7){
                this.aprovado = true;
                NotaMedia m = new NotaMedia(mediaInicial);
                return m;
            //Caso nao seja ira precisar do exame, entao calcula-se a media final
            } else {
                double mediaFinal = (mediaInicial + exame)/2;
                // Caso maior que 5 aprovado...
                if (mediaFinal > 5){
                    this.aprovado = true;
                    NotaMedia m = new NotaMedia(mediaFinal);
                    return m;
                //senao reprovado.
                }else{
                    this.aprovado = false;
                    NotaMedia m = new NotaMedia(mediaFinal);
                    return m;
                }
            }
        //Se o curso for uma POS-GRADUACAO
        }else{
            //Identificar se a media incial é maior ou igual a 5
            if (mediaInicial >= 5){
                this.aprovado = true;
                NotaMedia m = new NotaMedia(mediaInicial);
                return m;
            //Caso nao seja ira precisar do exame, entao calcula-se a media final
            } else {
                double mediaFinal = (mediaInicial + exame)/2;
                // Caso maior que 5 aprovado...
                if (mediaFinal > 5){
                    this.aprovado = true;
                    NotaMedia m = new NotaMedia(5.0); // Media vai ser 5 idependente do valor da media final
                    return m;
                //senao reprovado.
                }else{
                    this.aprovado = false;
                    NotaMedia m = new NotaMedia(mediaFinal);
                    return m;
                }
            }
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public NotaNP1 getNotaNP1() {
        return notaNP1;
    }

    public void setNotaNP1(NotaNP1 notaNP1) {
        this.notaNP1 = notaNP1;
    }

    public NotaNP2 getNotaNP2() {
        return notaNP2;
    }

    public void setNotaNP2(NotaNP2 notaNP2) {
        this.notaNP2 = notaNP2;
    }

    public NotaRep getNotaRep() {
        return notaRep;
    }

    public void setNotaRep(NotaRep notaRep) {
        this.notaRep = notaRep;
    }

    public NotaExame getNotaExame() {
        return notaExame;
    }

    public void setNotaExame(NotaExame notaExame) {
        this.notaExame = notaExame;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public NotaMedia getMedia() {
        return media;
    }

    public void setMedia(NotaMedia media) {
        this.media = media;
    }
}
