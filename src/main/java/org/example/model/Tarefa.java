package org.example.model;

import java.util.Date;

public class Tarefa {

    private int id;
    private String nome;
    private String descricao;
    private boolean status;
    private String observacao;
    private Date prazo;
    private Date dataCriacao;
    private Date dataAtualizacao;
    private int projetoId;

    public Tarefa() {
        this.dataCriacao = new Date();

    }

    public Tarefa(int id, String nome, String descricao, boolean status, String observacao, Date prazo, Date dataCriacao, Date dataAtualizacao, int projetoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.observacao = observacao;
        this.prazo = prazo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.projetoId = projetoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", observacao='" + observacao + '\'' +
                ", prazo=" + prazo +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", projetoId=" + projetoId +
                '}';
    }
}
