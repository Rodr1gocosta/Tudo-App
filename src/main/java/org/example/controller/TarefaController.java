package org.example.controller;

import org.example.model.Tarefa;
import org.example.util.ConnectioFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    public void save(Tarefa tarefa) throws SQLException {
        String sql = "INSERT INTO tarefa (nome, descricao, status, observacao, prazo, data_criacao, data_atualizacao, projeto_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, tarefa.getNome());
            statement.setString(2, tarefa.getDescricao());
            statement.setBoolean(3, tarefa.getStatus());
            statement.setString(4, tarefa.getObservacao());
            statement.setDate(5, new Date(tarefa.getPrazo().getTime()));
            statement.setDate(6, new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(7, new Date(tarefa.getDataAtualizacao().getTime()));
            statement.setInt(8, tarefa.getProjetoId());

            statement.execute();

        }   catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa" + ex.getMessage(), ex);
        }   finally {
            ConnectioFactory.closeConnection(connection, statement);
        }

    }

    public void update(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET " +
                "nome = ?, " +
                "descricao = ?, " +
                "status = ?, " +
                "observacao = ?, " +
                "prazo = ?, " +
                "data_criacao = ?, " +
                "data_atualizacao = ?, " +
                "projeto_id = ? " +
                "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, tarefa.getNome());
            statement.setString(2, tarefa.getDescricao());
            statement.setBoolean(3, tarefa.getStatus());
            statement.setString(4, tarefa.getObservacao());
            statement.setDate(5, new Date(tarefa.getPrazo().getTime()));
            statement.setDate(6, new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(7, new Date(tarefa.getDataAtualizacao().getTime()));
            statement.setInt(8, tarefa.getProjetoId());
            statement.setInt(9, tarefa.getId());

            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }



    }

    public void dalete(int id) throws SQLException {
        String sql = "DELETE FROM tarefa WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    public List<Tarefa> getAll(int id) {
        String sql = "SELECT * FROM tarefa WHERE projeto_id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Tarefa> tarefas = new ArrayList<>();

        try {
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setNome(resultSet.getString("nome"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setStatus(resultSet.getBoolean("status"));
                tarefa.setObservacao(resultSet.getString("observacao"));
                tarefa.setPrazo(resultSet.getDate("prazo"));
                tarefa.setDataCriacao(resultSet.getDate("data_criacao"));
                tarefa.setDataAtualizacao(resultSet.getDate("data_atualizacao"));
                tarefa.setProjetoId(resultSet.getInt("projeto_id"));

                tarefas.add(tarefa);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao consultar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement, resultSet);
        }

        return tarefas;
    }
}
