package com.mycompany.universidadeamazonia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        boolean estaNoMenu = true;
        EscreverCSV escrever = new EscreverCSV();
        LerCSV ler = new LerCSV();
        ValidaInput validarInput = new ValidaInput();
        
        Scanner sc = new Scanner(System.in);
        
        while (estaNoMenu == true){
            System.out.println("Selecione o numero referente a uma das opçoes abaixo");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Adicionar curso");
            System.out.println("3 - Adicionar rendimento");
            System.out.println("4 - Listar todos os alunos");
            System.out.println("5 - Listar todos os cursos");
            System.out.println("6 - Listar historico de rendimentos de um aluno");
            System.out.println("7 - Listar historico de rendimentos do curso");
            System.out.println("0 - Sair do aplicativo");
           
            String selecionarOpcao = sc.nextLine(); // Usuario input o valor desejado
            String opcaoEscolhida = selecionarOpcao.replaceAll("\\s+", ""); // remove os espaços que possa ter no input do usuario
            
            Integer opcao = validarInput.validaEscolha(0, 7, opcaoEscolhida, sc);
            
            System.out.println("" + "\n");
            
            switch(opcao) {
                
            case 1:
                System.out.println("ADICIONANDO UM ALUNO \n");
                System.out.println("Digite o ID do ALUNO que você deseja adicionar: ");
                String dadosId = sc.nextLine();
                String idAluno = dadosId.replaceAll("\\s+", "");
                System.out.println("Digite o NOME do ALUNO que você deseja adicionar: ");
                String nomeAluno = sc.nextLine();
                //Instanciando um objeto aluno com os dados passados pelo usuario
                Aluno aluno = new Aluno(idAluno, nomeAluno);
                //Verificando se o Aluno ja existe antes de adiciona-lo
                boolean alunoJaExiste = ler.verificarAlunoJaExiste(aluno);
                if (alunoJaExiste == false){
                    escrever.adicionarAluno(aluno);
                    System.out.println("\n Adição concluida! \n");
                }else{
                    System.out.println("\n Aluno já esta registrado no sistema! \n");
                }
                break;
                
            case 2:
                System.out.println("\n ADICIONANDO UM CURSO \n");
                // Pega o input do nome do Curso feito pelo usuario
                System.out.println("Digite o NOME do CURSO que você deseja adicionar: ");
                String dadosNome = sc.nextLine();
                String nomeCursoLowerCase = dadosNome.replaceAll("\\s+", "");
                String nomeCurso = nomeCursoLowerCase.toUpperCase();
                // Pega o input do ano do Curso feito pelo usuario
                System.out.println("Digite o ANO que CURSO foi LECIONADO: ");
                String dadoAno = sc.nextLine();
                String anoCursoInput = dadoAno.replaceAll("\\s+", "");
                int anoCurso = validarInput.validaAno(anoCursoInput, sc);
                // Pega o input do tipo do Curso feito pelo usuario
                System.out.println("Selecione o TIPO do CURSO que você deseja adicionar: ");
                System.out.println("1 - GRADUÇÃO");
                System.out.println("2 - PÓS-GRADUÇÃO");
                String dadosTipo = sc.nextLine();
                String tipoCursoInput = dadosTipo.replaceAll("\\s+", "");
                int opcaoTipo = validarInput.validaEscolha(1, 2, tipoCursoInput, sc);
                //Baseado no tipo vou instanciar o objeto correspondente e salvar no CSV
                if (opcaoTipo == 1){
                    CursoGrad graducao = new CursoGrad(nomeCurso, anoCurso);
                    boolean graducaoJaExiste = ler.verificarCursoJaExiste(graducao);
                    if(graducaoJaExiste == false){
                        escrever.adicionarCurso(graducao);
                        System.out.println("\n Adição concluida! \n");
                    }else{
                        System.out.println("\n Curso já esta registrado no sistema! \n");
                    } 
                }else{
                    CursoPos pos = new CursoPos(nomeCurso, anoCurso);
                    boolean posJaExiste = ler.verificarCursoJaExiste(pos);
                    if(posJaExiste == false){
                        escrever.adicionarCurso(pos);
                        System.out.println("\n Adição concluida! \n");
                    }else{
                        System.out.println("\n Curso já esta registrado no sistema! \n");
                    } 
                }
                break;
                
            case 3:
                System.out.println("\n ADICIONANDO UM RENDIMENTO \n");
                System.out.println("Digite o ID do ALUNO que o RENDIMENTO pertence: ");
                String dadosIdRendimento = sc.nextLine();
                String idRendimento = dadosIdRendimento.replaceAll("\\s+", "");
                Aluno alunoRend = validarInput.validaIdAluno(idRendimento, sc);
                if (alunoRend != null){
                    // Pega o input do nome do Curso feito pelo usuario
                    System.out.println("Digite o NOME do CURSO que o RENDIMENTO pertence: ");
                    String dadoNomeCursoRend = sc.nextLine();
                    String cursoRendLowerCase = dadoNomeCursoRend.replaceAll("\\s+", "");
                    String cursoNomeRend = cursoRendLowerCase.toUpperCase();
                    // Pega o input do ano do Curso feito pelo usuario
                    System.out.println("Digite o ANO do CURSO que o RENDIMENTO pertence:");
                    String dadoAnoRend = sc.nextLine();
                    String cursoAnoRendInput = dadoAnoRend.replaceAll("\\s+", "");
                    int cursoAnoRend = validarInput.validaAno(cursoAnoRendInput, sc);
                    // Pega o input do tipo do Curso feito pelo usuario
                    System.out.println("Selecione o TIPO do CURSO que o RENDIMENTO pertence: ");
                    System.out.println("1 - GRADUÇÃO");
                    System.out.println("2 - PÓS-GRADUÇÃO");
                    String dadoTipoRend = sc.nextLine();
                    String cursoTipoRendInput = dadoTipoRend.replaceAll("\\s+", "");
                    int escolha = validarInput.validaEscolha(1, 2, cursoTipoRendInput, sc);
                    String cursoTipoRend; //Baseado na escolha do usuario a variavel vai ter um valor diferente
                    if (escolha == 1){
                        cursoTipoRend = "GRADUACAO";
                    }else{
                        cursoTipoRend = "POS_GRADUACAO";
                    }
                    //Valida se o curso existe baseado no input do usuario Instancia objeto curso
                    Curso cursoRend = validarInput.validaCurso(cursoNomeRend, cursoTipoRend, cursoAnoRend, sc);
                    if (cursoRend != null){
                        //Verificar se o ele ja existe para esse curso em especifico
                        boolean rendimentoExiste = ler.verificarRendimentoJaExiste(cursoNomeRend, cursoTipoRend, cursoAnoRend, alunoRend.getId());
                        if (rendimentoExiste == false){
                            //Pegando as nota NP1
                            System.out.println("Digite o valor da NOTA NP1 desse aluno: ");
                            String dadoNotaNP1Rend = sc.nextLine();
                            String cursoNotaNP1Rend = dadoNotaNP1Rend.replaceAll("\\s+", "");
                            double NP1 = validarInput.validaNota(cursoNotaNP1Rend, sc);
                            //Pegando as nota NP2
                            System.out.println("Digite o valor da NOTA NP2 desse aluno: ");
                            String dadoNotaNP2Rend = sc.nextLine();
                            String cursoNotaNP2Rend = dadoNotaNP2Rend.replaceAll("\\s+", "");
                            double NP2 = validarInput.validaNota(cursoNotaNP2Rend, sc);
                            //Pegando as nota da Reposicao
                            System.out.println("Digite o valor da NOTA Reposição desse aluno: ");
                            String dadoNotaRepRend = sc.nextLine();
                            String cursoNotaRepRend = dadoNotaRepRend.replaceAll("\\s+", "");
                            double Rep = validarInput.validaNota(cursoNotaRepRend, sc);
                            //Pegando as nota do Exame
                            System.out.println("Digite o valor da NOTA Exame desse aluno: ");
                            String dadoNotaExamRend = sc.nextLine();
                            String cursoNotaExamRend = dadoNotaExamRend.replaceAll("\\s+", "");
                            double Exam = validarInput.validaNota(cursoNotaExamRend, sc);
                            //Instanciar o Rendimento 
                            Rendimento rendimento = new Rendimento(alunoRend, cursoRend, NP1, NP2, Rep, Exam);
                            escrever.adicionarRendimento(rendimento);
                            System.out.println("\n Adição concluida! \n");
                        }else{
                            System.out.println("\n Esse rendimento já foi adicionado para esse aluno nesse curso \n");
                        }   
                    }else{
                        System.out.println("OPS! Não achamos nenhum Curso com os valores espedicificados. \n");
                        System.out.println("Recomenadamos que voce use a opção listar cursos no Menu Principal para certifica-se dos dados do curso desejado.\n");
                    }
                }else{
                    System.out.println("OPS! Não achamos nenhum aluno com esse ID. \n");
                    System.out.println("Recomenadamos que voce use a opção listar alunos no Menu Principal para certifica-se do ID desejado.\n");
                }
                break;
                
            case 4:
                ArrayList<Aluno> alunos = ler.listarTodosAlunos();
                if (alunos != null && !alunos.isEmpty()){
                    for (Aluno a : alunos){
                        System.out.println("Id: " +  a.getId());
                        System.out.println("Nome: " +  a.getNome()+ "\n");
                    }
                }else{
                    System.out.println("\nNao existe nenhum aluno cadastrado!\n");
                }
                break;
                
            case 5:
                ArrayList<Curso> cursos = ler.listarTodosCursos();
                if (cursos != null && !cursos.isEmpty()){
                    for (Curso c : cursos){
                        System.out.println("Nome: " +  c.getNome());
                        System.out.println("Nivel: " +  c.getNivel());
                        System.out.println("Ano: " +  c.getAnoCurso() + "\n");
                    }
                }else{
                    System.out.println("\nNao existe nenhum curso cadastrado!\n");
                }    
                break;
                
            case 6:
                System.out.println("Digite o ID do ALUNO que você deseja procurar: ");
                String dadosIdAlunoHist = sc.nextLine();
                String idAlunoHist = dadosIdAlunoHist.replaceAll("\\s+", "");
                Aluno alunoHist = validarInput.validaIdAluno(idAlunoHist, sc);
                ArrayList<Rendimento> rendimentosAluno = ler.listarHistoricoAluno(alunoHist.getId());
                if (rendimentosAluno != null && !rendimentosAluno.isEmpty()){
                System.out.println("\n Para o aluno " + alunoHist.getNome() + " os rendimentos foram:\n");
                for(Rendimento r : rendimentosAluno){
                    System.out.println("Curso " + r.getCurso().getNome() + " da " + r.getCurso().getNivel() + " de " + r.getCurso().getAnoCurso());
                    System.out.println("NP1: " + r.getNP1().getValor());
                    System.out.println("NP2: " + r.getNP2().getValor());
                    System.out.println("Reposição: " + r.getRep().getValor());
                    System.out.println("Exame: " + r.getExam().getValor());
                    System.out.println("MÉDIA: " + r.getMedia().getValor());
                    if (r.isAprovado() == true){
                        System.out.println("O aluno foi APROVADO nesse curso. \n");
                    }else{
                        System.out.println("O aluno foi REPROVADO nesse curso. \n");
                    }
                }
                }else{
                    System.out.println("\nNao existe nenhum rendimento para esse aluno!\n");
                }
                break;
                
            case 7:
                System.out.println("Digite o NOME do CURSO: ");
                String dadoNomeCursoHist = sc.nextLine();
                String cursoHistLowerCase = dadoNomeCursoHist.replaceAll("\\s+", "");
                String cursoNomeHist = cursoHistLowerCase.toUpperCase();
                // Pega o input do ano do Curso feito pelo usuario
                System.out.println("Digite o ANO do CURSO:");
                String dadoAnoHist = sc.nextLine();
                String cursoAnoHistInput = dadoAnoHist.replaceAll("\\s+", "");
                int cursoAnoHist = validarInput.validaAno(cursoAnoHistInput, sc);
                // Pega o input do tipo do Curso feito pelo usuario
                System.out.println("Selecione o TIPO do CURSO: ");
                System.out.println("1 - GRADUÇÃO");
                System.out.println("2 - PÓS-GRADUÇÃO");
                String dadoTipoHist = sc.nextLine();
                String cursoTipoHistInput = dadoTipoHist.replaceAll("\\s+", "");
                int escolha = validarInput.validaEscolha(1, 2, cursoTipoHistInput, sc);
                String cursoTipoHist; //Baseado na escolha do usuario a variavel vai ter um valor diferente
                if (escolha == 1){
                    cursoTipoHist = "GRADUACAO";
                }else{
                    cursoTipoHist = "POS_GRADUACAO";
                }
                //Valida se o curso existe baseado no input do usuario Instancia objeto curso
                Curso cursoHist = validarInput.validaCurso(cursoNomeHist, cursoTipoHist, cursoAnoHist, sc);
                ArrayList<Rendimento> rendimentosHist = ler.listarRendimentosDoCurso(cursoHist.getNome(), cursoHist.getNivel(), cursoHist.getAnoCurso());
                if (rendimentosHist != null && !rendimentosHist.isEmpty()){
                    System.out.println("\nPara o curso " + cursoHist.getNome() + " da " + cursoHist.getNivel() + " de " + cursoHist.getAnoCurso() + " os rendimentos foram:\n" );
                    for(Rendimento r : rendimentosHist){
                        System.out.println("Para o aluno " + r.getAluno().getNome() + " os rendimento foi:");
                        System.out.println("NP1: " + r.getNP1().getValor());
                        System.out.println("NP2: " + r.getNP2().getValor());
                        System.out.println("Reposição: " + r.getRep().getValor());
                        System.out.println("Exame: " + r.getExam().getValor());
                        System.out.println("MÉDIA: " + r.getMedia().getValor());
                        if (r.isAprovado() == true){
                            System.out.println("O aluno foi APROVADO nesse curso. \n");
                        }else{
                            System.out.println("O aluno foi REPROVADO nesse curso. \n");
                        }
                }
                }else{
                    System.out.println("\nNao existe nenhum rendimento para esse curso!\n");
                }
                break;
                
            case 0:
                System.out.println("Obrigado! Até Mais");
                estaNoMenu = false;
                break;
            }
          
        }
        
        sc.close();  
        
    }
}
