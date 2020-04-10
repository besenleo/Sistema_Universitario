package com.mycompany.universidadeamazonia;

public abstract class Nota {
    private double nota;

    public Nota(double nota){
        if (nota < 0 || nota > 10){
            this.nota = nota;
        }else{
            throw new IllegalArgumentException("Valor da nota não pertence entre 0 a 10: nota = " + this.nota);
        }
    }
    
    public double getNota() {
        return nota;
    }
    public void setNota(double nota){
        this.nota = nota;
    }
}
