package edu.betania.dio;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Registrando os conteúdos disponíveis.

        Curso curso1 = new Curso();
        curso1.setTitulo("Introdução POO");
        curso1.setDescricao("Curso introdutório");
        curso1.setCargaHoraria(3);

        Curso curso2 = new Curso();
        curso2.setTitulo("Intermediário POO");
        curso2.setDescricao("Curso intermediário");
        curso2.setCargaHoraria(8);

        Curso curso3 = new Curso();
        curso3.setTitulo("Avançado POO");
        curso3.setDescricao("Curso anvançado");
        curso3.setCargaHoraria(10);

        Curso curso4 = new Curso();
        curso4.setTitulo("Introdução Java");
        curso4.setDescricao("Curso introdutório");
        curso4.setCargaHoraria(2);

        Curso curso5 = new Curso();
        curso5.setTitulo("Java Básico");
        curso5.setDescricao("Curso de fundamentos Java");
        curso5.setCargaHoraria(4);

        Curso curso6 = new Curso();
        curso6.setTitulo("Java Intermediário");
        curso6.setDescricao("Curso intermediário de Java");
        curso6.setCargaHoraria(6);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Primeira Mentoria");
        mentoria1.setDescricao("Mentoria de apresentação");

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Segunda Mentoria");
        mentoria2.setDescricao("Mentoria de tira-dúvidas");

        Mentoria mentoria3 = new Mentoria();
        mentoria3.setTitulo("Terceira Mentoria");
        mentoria3.setDescricao("Mentoria de encerramento");

        // Registrandos os Bootcamps.

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp POO");
        bootcamp1.setDescricao("Bootcamp estudos POO");
        bootcamp1.getConteudos().add(mentoria1);
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria2);
        bootcamp1.getConteudos().add(curso3);
        bootcamp1.getConteudos().add(mentoria3);

        Bootcamp bootcamp2 = new Bootcamp();
        bootcamp2.setNome("Bootcamp Java");
        bootcamp2.setDescricao("Bootcamp estudos Java");
        bootcamp2.getConteudos().add(mentoria1);
        bootcamp2.getConteudos().add(curso4);
        bootcamp2.getConteudos().add(curso5);
        bootcamp2.getConteudos().add(mentoria2);
        bootcamp2.getConteudos().add(curso6);
        bootcamp2.getConteudos().add(mentoria3);

        // Iniciando a matricula do aluno.

        Aluno aluno1 = new Aluno();
        System.out.println("Para matricular-se, digite seu nome: ");
        String novoAluno = leitor.next();
        aluno1.setNome(novoAluno);
        System.out.println("Olá, " + aluno1.getNome().toUpperCase() + "!");
        System.out.println("Para se inscrever no Bootcamp POO, digite 1. Para se inscrever no Bootcamp Java, digite 2.");
        int resposta = leitor.nextInt();
        while(resposta < 1 || resposta > 2) {
            System.out.println("Insira um número válido.");
            resposta = leitor.nextInt();
        }
        if(resposta == 1){
            aluno1.inscreverBootcamp(bootcamp1);
        } else {
            aluno1.inscreverBootcamp(bootcamp2);
        }
        System.out.println("O conteúdo do seu Bootcamp é: " + aluno1.getConteudosInscritos());

        // Registrando o progresso do aluno e imprimindo mensagens de acordo com o progresso.

        for(int i = aluno1.getConteudosInscritos().size(); i != 0; i--) {
            System.out.println("Marcar conteúdo como concluído? Digite Sim ou Não:");
            String conclusaoCurso = leitor.next().toUpperCase();
            while(!conclusaoCurso.equals("SIM") && !conclusaoCurso.equals("NÃO") && !conclusaoCurso.equals("NAO")) {
                System.out.println("Insira uma resposta válida.");
                conclusaoCurso = leitor.next().toUpperCase();
            }
            switch (conclusaoCurso) {
                case "SIM": {
                    aluno1.progredir();
                    if (aluno1.getConteudosInscritos().size() == 0) {
                        System.out.println("Parabéns! Você concluiu o Bootcamp com sucesso!");
                    } else {
                        System.out.println("Parabéns! Você já concluiu: " + aluno1.getConteudosConcluidos());
                        System.out.println("Seu conteúdo a estudar é: " + aluno1.getConteudosInscritos());
                        System.out.println("Seu XP é: " + aluno1.calcularTotalXp());
                        System.out.println("Siga para o próximo conteúdo.");
                    }
                    break;
                }
                case "NÃO":
                case "NAO": {
                    System.out.println("Primeiro, finalize seu conteúdo.");
                    break;
                }
            }
        }
        System.out.println("Seu XP final é: " + aluno1.calcularTotalXp());
        leitor.close();
    }
}