/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universidadeamazonia;

import java.util.Scanner;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         
        System.out.println("Enter input string to be cleaned from white spaces...!");
         
        String inputString = sc.nextLine();
        
        String stringWithoutSpaces = inputString.replaceAll("\\s+", "");
        
        System.out.println("Input String : "+ inputString);
         
        System.out.println("Input String Without Spaces : "+stringWithoutSpaces);
        
//        System.out.println("Nota");
//        String inputString = sc.nextLine();
//        double nota = new Double(inputString); // recebe 1 e retorna 1.0

        sc.close();
    }
}
