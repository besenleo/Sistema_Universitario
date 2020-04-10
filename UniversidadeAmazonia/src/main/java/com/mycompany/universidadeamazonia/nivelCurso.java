/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universidadeamazonia;

/**
 *
 * @author Leo
 */
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
