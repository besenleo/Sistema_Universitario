package com.mycompany.universidadeamazonia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
//        Scanner sc = new Scanner(System.in);
//         
//        System.out.println("Enter input string to be cleaned from white spaces...!");
//         
//        String inputString = sc.nextLine();
//        
//        String stringWithoutSpaces = inputString.replaceAll("\\s+", "");
//        
//        System.out.println("Input String : "+ inputString);
//         
//        System.out.println("Input String Without Spaces : " + stringWithoutSpaces);
//        
////        System.out.println("Nota");
////        String inputString = sc.nextLine();
////        double nota = new Double(inputString); // recebe 1 e retorna 1.0
//
//        sc.close();

/* TESTES DO ESCREVER E LER DO CSV*/

        EscreverCSV escrever = new EscreverCSV();

//        TESTE CRIAR ALUNO         
//        Aluno aluno = new Aluno("b12","Luiz");
//        escrever.adicionarAluno(aluno);

//        TESTE CRIAR CURSO GRADUACAO        
//        CursoGrad lpoo = new CursoGrad("DB", 2020);
//        escrever.adicionarCurso(lpoo);

//        TESTE CRIAR CURSO POS-GRADUACAO   
//        CursoPos apoo = new CursoPos("DB", 2020);
//        escrever.adicionarCurso(apoo);

//        TESTE INSTANCIAR E ADICIONAR O RENDIMENTO
//        Rendimento rend = new Rendimento("b15", "LpOo", "GrAduaCaO", 2020, 10, 9, 0, 0);
//        System.out.println(rend.getAluno().getNome() + ": " + rend.getMedia().getValor() + " " + rend.isAprovado());
//        
//        Rendimento rend2 = new Rendimento("b12", "LpOo", "GrAduaCaO", 2020, 3, 2, 0, 1);
//        System.out.println(rend2.getAluno().getNome() + ": " + rend2.getMedia().getValor() + " " + rend2.isAprovado());
//        
//        Rendimento rend3 = new Rendimento("b15", "ApOO", "POS_GrAduaCaO", 2020, 2, 5, 0, 1);
//        System.out.println(rend3.getAluno().getNome() + ": " + rend3.getMedia().getValor() + " " + rend3.isAprovado());
//        
//        Rendimento rend4 = new Rendimento("b12", "ApOo", "POS_GrAduaCaO", 2020, 10, 0, 10, 0);
//        System.out.println(rend4.getAluno().getNome() + ": " + rend4.getMedia().getValor() + " " + rend4.isAprovado());
//        
//        escrever.adicionarRendimento(rend);
//        escrever.adicionarRendimento(rend2);
//        escrever.adicionarRendimento(rend3);
//        escrever.adicionarRendimento(rend4);


        LerCSV listar = new LerCSV();

//        TESTE LISTAR TODOS OS ALUNOS    
//        ArrayList<Aluno> alunos = listar.listarTodosAlunos();
//        for (Aluno aluno : alunos) {
//            System.out.println(aluno.getId() + " " + aluno.getNome());
//        }

//        TESTE LISTAR TODOS OS CURSOS
//        ArrayList<Curso> cursos = listar.listarTodosCursos();
//        for (Curso curso : cursos) {
//            System.out.println(curso.getNome() + " " + curso.getNivel() + " " + curso.getAnoCurso());
//        }

//        TESTE DO VERIFICAR SE CURSO JA EXISTE 
//        boolean resultado = listar.verificarCursoJaExiste(lpoo);
//        if (resultado == true){
//            System.out.println("Curso ja existe!");
//        }
//        
//        boolean resultado2 = listar.verificarCursoJaExiste(apoo);
//        if (resultado2 == true){
//            System.out.println("Curso 2 ja existe!");
//        }

//        TESTE DO ACHAR ALUNO PELO ID
//        Aluno aluno = listar.acharAlunoPeloId("n15");
//        if (aluno != null){
//            System.out.println(aluno.getNome());
//        }
//        Aluno aluno = listar.acharAlunoPeloId("a15");
//        if (aluno == null){
//            System.out.println("Nao tem aluno com esse id");
//        }  

//        TESTE DO ACHAR CURSO PELO NOME
//        Curso curso = listar.acharCurso("LpOo", "GrAduaCaO", 2019);
//        if (curso != null){
//            System.out.println(curso.getNome() + " " + curso.getNivel() + " " + curso.getAnoCurso());
//        }
        
//        Curso curso2 = listar.acharCurso("AMANA", "GrAduaCaO", 2020);
//        if (curso2 == null){
//            System.out.println("Esse curso nao foi cadastro");
//        }

//        TESTAR LISTAR TODOS OS RENDIMENTOS DE UM CURSO
//        ArrayList<Rendimento> rendimentos = listar.listarRendimentosDoCurso("LpOo", "GrAduaCaO", 2020);
//        if(rendimentos != null){
//            for(Rendimento r : rendimentos){
//                System.out.println(r.getAluno().getNome() + "- Media: " + r.getMedia().getValor() + " - Aprovado? " + r.isAprovado());
//            }
//        }else{
//            System.out.println("Nao deu certo!");
//        }      
//        ArrayList<Rendimento> rNaoEhParaDarCerto = listar.listarRendimentosDoCurso("AMANA", "GrAduaCaO", 2020);
//        if(rNaoEhParaDarCerto != null){
//            for(Rendimento r : rNaoEhParaDarCerto){
//                System.out.println(r.getAluno().getNome() + "- Media: " + r.getMedia().getValor() + " - Aprovado? " + r.isAprovado());
//            }
//        }else{
//            System.out.println("Nao tem esse curso msm!");
//        }





    }
}
