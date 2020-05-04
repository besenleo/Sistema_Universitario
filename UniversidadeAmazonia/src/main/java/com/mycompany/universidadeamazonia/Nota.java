package com.mycompany.universidadeamazonia;

public class Nota {
    private double valor;
    
    public Nota(double valor){
        this.setValor(valor);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0 || valor > 10){
            this.valor = valor;
        }else{
            throw new IllegalArgumentException("Valor da nota não pertence entre 0 a 10. Você tentou atribuir: " + valor);
        }
    }
}
