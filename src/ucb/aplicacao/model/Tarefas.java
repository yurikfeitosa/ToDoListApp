package ucb.aplicacao.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefas {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataCriacao;

    // Construtor padrão
    public Tarefas() {
        this.dataCriacao = LocalDateTime.now();
        this.completa = false; // inicializando explicitamente
    }

    // Construtor com título
    public Tarefas(String titulo) {
        this();
        this.titulo = titulo;
    }

    // Construtor com título e descrição
    public Tarefas(String titulo, String descricao) {
        this(titulo);
        this.descricao = descricao;
    }

    // Construtor completo
    public Tarefas(Long id, String titulo, String descricao, boolean completa) {
        this(titulo, descricao);
        this.id = id;
        this.completa = completa;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // Método para retornar data formatada
    public String getDataCriacaoFormatadaPtBr() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dataCriacao.format(formatter);
    }
}

