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

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = entrada.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = entrada.nextLine();
                    Tarefas nova = servico.criarTarefa(titulo, descricao);
                    System.out.println("Criada: " + nova.getId() + " - " + nova.getTitulo());
                }

                case 2 -> {
                    List<Tarefas> tarefas = servico.listarTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("Lista de Tarefas:");
                        for (Tarefas t : tarefas) {
                            System.out.println(t.getId() + " - " + t.getTitulo() + " | " + t.getDescricao()
                                    + (t.isCompleta() ? " [concluída]" : ""));
                        }
                    }
                }

                case 3 -> {
                    System.out.print("ID da tarefa: ");
                    long id = entrada.nextLong();
                    entrada.nextLine();

                    System.out.print("Novo título (vazio mantém): ");
                    String novoTitulo = entrada.nextLine();

                    System.out.print("Nova descrição (vazio mantém): ");
                    String novaDesc = entrada.nextLine();

                    System.out.print("Alterar status de concluída? (s = marcar, n = desmarcar, Enter = manter): ");
                    String resp = entrada.nextLine().trim();
                    Boolean novoCompleto = null;
                    if (resp.equalsIgnoreCase("s")) novoCompleto = true;
                    else if (resp.equalsIgnoreCase("n")) novoCompleto = false;

                    boolean ok = servico.atualizarTarefa(id, novoTitulo, novaDesc, novoCompleto);
                    System.out.println(ok ? "Atualizada." : "Tarefa não encontrada.");
                }

                case 4 -> {
                    System.out.print("ID da tarefa: ");
                    long id = entrada.nextLong();
                    entrada.nextLine();
                    boolean ok = servico.removerTarefa(id);
                    System.out.println(ok ? "Removida." : "Tarefa não encontrada.");
                }
