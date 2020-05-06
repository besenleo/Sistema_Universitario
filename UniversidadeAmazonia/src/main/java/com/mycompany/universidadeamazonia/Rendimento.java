package com.mycompany.universidadeamazonia;

public class Rendimento {
    private Aluno aluno;
    private Curso curso;
    private Nota NP1;
    private Nota NP2;
    private Nota rep;
    private Nota exam;
    private Nota media;
    private boolean aprovado;
    
    //o parametro curso vai ser mudado para nome, nivel e ano
    public Rendimento(Aluno aluno, Curso curso, double notaNP1, double notaNP2, double notaRep, double notaExam){
        LerCSV leitura = new LerCSV(); //instanciando a classe de leitura
        // Verificar se o curso existe
        boolean alunoExiste = leitura.verificarAlunoJaExiste(aluno);
        if(alunoExiste == true){
            this.aluno = aluno;
        }else{
            throw new IllegalArgumentException("Nenhum aluno encontrado quando tentamos criar o rendimento!");
        }
         // Verificar se o curso existe
        boolean cursoExiste = leitura.verificarCursoJaExiste(curso);
        if(cursoExiste == true){
            this.curso = curso;
        }else{
            throw new IllegalArgumentException("Nenhum curso encontrado quando tentamos criar o rendimento!");
        }
        
        this.NP1 = new Nota(notaNP1);
        
        this.NP2 = new Nota(notaNP2);
        
        this.rep = new Nota(notaRep);
        
        this.exam = new Nota(notaExam);
        
        this.media = new Nota(calcularMedia(notaNP1, notaNP2, notaRep, notaExam, curso));
        
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

    public String registroParaCSV(){
        return this.getAluno().getId() + ";" + this.getNP1().getValor() + ";" + this.getNP2().getValor() + ";" + this.getRep().getValor() + ";" + this.getExam().getValor() + "\n";
    }
    
    public Aluno getAluno() {
        //return aluno.getNome();
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public Nota getNP1() {
        return NP1;
    }

    public Nota getNP2() {
        return NP2;
    }

    public Nota getRep() {
        return rep;
    }

    public Nota getExam() {
        return exam;
    }

    public Nota getMedia() {
        return media;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
   
}
