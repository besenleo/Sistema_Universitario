package com.mycompany.universidadeamazonia;

public class Notas {
    private double notaNP1;
    private double notaNP2;
    private double notaRep;
    private double notaExam;
    private double notaMedia;

    public Notas(double notaNP1, double notaNP2, double notaRep, double notaExam){
        this.setNotaNP1(notaNP1);
        this.setNotaNP2(notaNP2);
        this.setNotaRep(notaRep);
        this.setNotaExam(notaExam);
    }
    
    public Notas(double media){
        this.setNotaMedia(media);
    }
    
    
    public double getNotaNP1() {
        return notaNP1;
    }

    public void setNotaNP1(double notaNP1) {
        if (notaNP1 >= 0 && notaNP1 <= 10){
            this.notaNP1 = notaNP1;
        }else{
            throw new IllegalArgumentException("Valor da nota da NP1 não pertence entre 0 a 10. Você tentou atribuir: " + notaNP1);
        }
    }

    public double getNotaNP2() {
        return notaNP2;
    }

    public void setNotaNP2(double notaNP2) {
        if (notaNP2 < 0 || notaNP2 > 10){
            this.notaNP2 = notaNP2;
        }else{
            throw new IllegalArgumentException("Valor da nota da NP2 não pertence entre 0 a 10. Você tentou atribuir: " + notaNP2);
        }
    }

    public double getNotaRep() {
        return notaRep;
    }

    public void setNotaRep(double notaRep) {
        if (notaRep < 0 || notaRep > 10){
            this.notaRep = notaRep;
        }else{
            throw new IllegalArgumentException("Valor da nota da Reposição não pertence entre 0 a 10. Você tentou atribuir: " + notaRep);
        }
    }

    public double getNotaExam() {
        return notaExam;
    }

    public void setNotaExam(double notaExam) {
        if (notaExam < 0 || notaExam > 10){
            this.notaExam = notaExam;
        }else{
            throw new IllegalArgumentException("Valor da nota do Exame não pertence entre 0 a 10. Você tentou atribuir: " + notaExam);
        }
    }
    
    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        if (notaMedia < 0 || notaMedia > 10){
            this.notaMedia = notaExam;
        }else{
            throw new IllegalArgumentException("Valor da nota media não pertence entre 0 a 10. Você tentou atribuir: " + notaMedia);
        }
    }
}
