package ucb.aplicacao.service;

import java.util.ArrayList;
import java.util.List;
import ucb.aplicacao.model.Tarefas;

public class TarefaService {

    private final List<Tarefas> tarefas = new ArrayList<>();
    private Long proximoId = 1L;

    // Criar nova tarefa
    public Tarefas criarTarefa(String titulo, String descricao) {
        Tarefas tarefa = new Tarefas(proximoId++, titulo, descricao, false);
        tarefas.add(tarefa);
        return tarefa;
    }

    // Listar todas as tarefas
    public List<Tarefas> listarTarefas() {
        return new ArrayList<>(tarefas); // retorna cópia para segurança
    }

    // Atualizar tarefa existente
    public boolean atualizarTarefa(Long id, String novoTitulo, String novaDesc, Boolean novoCompleto) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                if (novoTitulo != null && !novoTitulo.isBlank()) {
                    tarefa.setTitulo(novoTitulo);
                }
                if (novaDesc != null && !novaDesc.isBlank()) {
                    tarefa.setDescricao(novaDesc);
                }
                if (novoCompleto != null) {
                    tarefa.setCompleta(novoCompleto);
                }
                return true;
            }
        }
        return false;
    }

    // Remover tarefa pelo id
    public boolean removerTarefa(Long id) {
        return tarefas.removeIf(t -> t.getId().equals(id));
    }

    // Pesquisar tarefas pelo título
    public List<Tarefas> pesquisarPorTitulo(String termo) {
        List<Tarefas> resultado = new ArrayList<>();
        String busca = (termo == null) ? "" : termo.toLowerCase();

        for (Tarefas tarefa : tarefas) {
            String titulo = tarefa.getTitulo();
            if (titulo != null && titulo.toLowerCase().contains(busca)) {
                resultado.add(tarefa);
            }
        }
        return resultado;
    }

    // Listar apenas as tarefas concluídas
    public List<Tarefas> listarConcluidas() {
        List<Tarefas> resultado = new ArrayList<>();
        for (Tarefas tarefa : tarefas) {
            if (tarefa.isCompleta()) {
                resultado.add(tarefa);
            }
        }
        return resultado;
    }
}
