package ucb.aplicacao.cli;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import ucb.aplicacao.model.Tarefas;
import ucb.aplicacao.service.TarefaService;

public class AppToDoListQua {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner entrada = new Scanner(System.in);
        TarefaService servico = new TarefaService();

        while (true) {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Pesquisar Tarefa");
            System.out.println("6. Tarefas concluídas");
            System.out.println("7. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();
