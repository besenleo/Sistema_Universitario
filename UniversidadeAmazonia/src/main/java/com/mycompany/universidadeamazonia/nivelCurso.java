package com.mycompany.universidadeamazonia;

public enum nivelCurso {
    GRADUACAO("graducao"), 
    POS_GRADUACAO("pos-graducao");

    private String curso;

    nivelCurso(String curso) {
        this.curso = curso;
    }
    
    public String getCurso(){
        return curso;
    }
}
