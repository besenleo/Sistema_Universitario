package com.mycompany.universidadeamazonia;

import java.util.Scanner;

public class ValidaInput {
    public Integer validaEscolha(int minValor, int maxValor, String opcaoEscolhida, Scanner sc){
        /**
         *  Essa funcao recebe o menor valor possivel de uma opção (minValor) e 
         *  o maior valor possivel (maxValor). 
         *  E força o usuario a digitar um desses valore no objecto Scanner.
         *  Isso impossibilita que o usuario tente passar qualquer valor que nao
         *  seja um inteiro para as opçoes e mantem o programa em um estado estavel
         *  durante o erro do usuario.
         *  @return int opcao (opcao escolhida pelo usuario)
         */
        Integer opcao;
        try{
            opcao = Integer.parseInt(opcaoEscolhida); // tenta converter a opçao em int
            return opcao;
        }catch (Exception ex){
            // caso nao funcione ele entre aqui. E vai pedir um int para o usuario ate que ele prove o valor correto.
            opcao = 100;
            while(!(opcao>= minValor && opcao <= maxValor)){
                System.out.println("Selecione apenas o número da opção desejada");
                String selecionarOpcaoEx = sc.nextLine();
                String opcaoEscolhidaEx = selecionarOpcaoEx.replaceAll("\\s+", "");
                try{
                    opcao = Integer.parseInt(opcaoEscolhidaEx);
                }catch (Exception ex1){}
            }
            return opcao;
        }   
    }
    
    public Integer validaAno(String anoDigitado, Scanner sc){
        Integer ano;
        try{
            ano = Integer.parseInt(anoDigitado); // tenta converter a opçao em int
            if ((int) (Math.log10(ano) + 1) == 4){ //verifica se o ano tem 4 digitos
                return ano;
            }else{
                //caso nao tenha 4 digitos. Entra em loop ate que o usuario digite um ano valido.
                ano = 0;
                while(!((int) (Math.log10(ano) + 1) == 4)){
                    System.out.println("O ano deve conter 4 digitos. Ex: 2019");
                    String tentivaAno = sc.nextLine();
                    String anoDigitadoNovamente = tentivaAno.replaceAll("\\s+", "");
                    try{
                        ano = Integer.parseInt(anoDigitadoNovamente);
                    }catch (Exception ex1){}
                }
                return ano;
            }
        }catch (Exception ex){
            // caso o parseInt nao funcione, ele entra aqui. E vai pedir por um int de 4 digitos para o usuario, ate que ele digite um valor esperado.
            ano = 0;
            while(!((int) (Math.log10(ano) + 1) == 4)){
                System.out.println("O ano deve conter 4 digitos. Ex: 2019");
                String tentivaAno = sc.nextLine();
                String anoDigitadoNovamente = tentivaAno.replaceAll("\\s+", "");
                try{
                    ano = Integer.parseInt(anoDigitadoNovamente);
                }catch (Exception ex1){}
            }
            return ano;
        }
    }
    
    public Aluno validaIdAluno(String idAluno, Scanner sc){
        /**
         *  Essa funcao recebe o id do Aluno digitado pelo usuario.
         *  Ela tenta usar o acharAlunoPeloId para resgatar o objeto Aluno que tem esse id do alunos.csv
         *  Caso em duas tentativas ele nao ache, o valor é returnado null, \
         *  para que no Main o usuario seja enviado para a tela inicial novamente.
         *  @return Aluno or null
         */
       LerCSV ler = new LerCSV();
       Aluno aluno = ler.acharAlunoPeloId(idAluno);
       if (aluno == null){
           System.out.println("OPS! Não achamos nenhum aluno com esse ID. Tente novamente!");
           String dadosIdRendimento = sc.nextLine();
           String idRendimento = dadosIdRendimento.replaceAll("\\s+", "");
           Aluno aluno2 = ler.acharAlunoPeloId(idRendimento);
           return aluno2;
       }else{
           return aluno;
       }
    }
    
    public Curso validaCurso(String nomeCurso, String nivelCurso, int anoCurso, Scanner sc){
        /**
         *  Essa funcao recebe o nome, nivel e ano do Curso digitado pelo usuario.
         *  Ela tenta usar o acharCurso para resgatar o objeto Curso que tem esses valores no cursos.csv
         *  Caso em duas tentativas ele nao ache, o valor é returnado null, 
         *  para que no Main o usuario seja enviado para a tela inicial novamente.
         *  @return Curso or null
         */
       LerCSV ler = new LerCSV();
       Curso curso = ler.acharCurso(nomeCurso, nivelCurso, anoCurso);
       if (curso == null){
           System.out.println("OPS! Não achamos nenhum curso com esses atributos. Tente novamente!");
           System.out.println("Digite o NOME do CURSO que o RENDIMENTO do aluno pertence: ");
           String dadoNomeCursoRend = sc.nextLine();
           String cursoRendLowerCase = dadoNomeCursoRend.replaceAll("\\s+", "");
           String cursoNomeRend = cursoRendLowerCase.toUpperCase();
           // Pega o input do ano do Curso feito pelo usuario
           System.out.println("Digite o ANO do CURSO que o RENDIMENTO do aluno pertence:");
           String dadoAnoRend = sc.nextLine();
           String cursoAnoRendInput = dadoAnoRend.replaceAll("\\s+", "");
           int cursoAnoRend = this.validaAno(cursoAnoRendInput, sc);
           // Pega o input do tipo do Curso feito pelo usuario
           System.out.println("Selecione o TIPO do CURSO que você deseja adicionar: ");
           System.out.println("1 - GRADUÇÃO");
           System.out.println("2 - PÓS-GRADUÇÃO");
           String dadoTipoRend = sc.nextLine();
           String cursoTipoRendInput = dadoTipoRend.replaceAll("\\s+", "");
           int escolha = this.validaEscolha(1, 2, cursoTipoRendInput, sc);
           String cursoTipoRend; //Baseado na escolha do usuario a variavel vai ter um valor diferente
                if (escolha == 1){
                    cursoTipoRend = "GRADUACAO";
                }else{
                    cursoTipoRend = "POS_GRADUACAO";
                }
           Curso curso2 = ler.acharCurso(nomeCurso, nivelCurso, anoCurso);
           return curso2;
       }else{
           return curso;
       }
    }
    
    public double validaNota(String valor, Scanner sc){
       
        Double nota;
        try{
            if (valor.equals("")){
                return 0;// se o valor for uma String vazia retorna zero como nota.
            }
            nota = Double.parseDouble(valor); // tenta converter a opçao em int
            return nota;
        }catch (Exception ex){
            // caso nao funcione ele entre aqui. E vai pedir um int para o usuario ate que ele prove o valor correto.
            String notaExceptionTentativa = "Diferente de vazio";
            nota = 100.00;
            while(!(nota >= 0 && nota <= 10) || notaExceptionTentativa.equals("")){
                System.out.println("Selecione apenas o número da opção desejada");
                String notaException = sc.nextLine();
                notaExceptionTentativa = notaException.replaceAll("\\s+", "");
                try{
                    nota = Double.parseDouble(notaExceptionTentativa);
                }catch (Exception ex1){}
            }
            if (notaExceptionTentativa.equals("")){
                return 0; // se o valor for uma String vazia retorna zero como nota.
            }
            return nota;
        }
    }
    
    
}
