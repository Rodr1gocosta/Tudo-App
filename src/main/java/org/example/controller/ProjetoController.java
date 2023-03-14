package org.example.controller;

import org.example.model.Projeto;
import org.example.util.ConnectioFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoController {

    public void save(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO projetos " +
                "(nome, " +
                "descricao, " +
                "data_criacao, " +
                "data_atualizacao) " +
                "VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, projeto.getNome());
            statement.setString(2, projeto.getDescricao());
            statement.setDate(3, new Date(projeto.getDataCriacao().getTime()));
            statement.setDate(4, new Date(projeto.getDataAtualizacao().getTime()));

            statement.execute();

        }   catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a projeto" + ex.getMessage(), ex);
        }   finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    public void update(Projeto projeto) {
        String sql = "UPDATE projetos SET " +
                "nome = ?, " +
                "descricao = ?, " +
                "data_criacao = ?, " +
                "data_atualizacao = ? " +
                "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, projeto.getNome());
            statement.setString(2, projeto.getDescricao());
            statement.setDate(3, new Date(projeto.getDataCriacao().getTime()));
            statement.setDate(4, new Date(projeto.getDataAtualizacao().getTime()));
            statement.setInt(5, projeto.getId());

            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a projeto" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    public void dalete(int id) throws SQLException {
        String sql = "DELETE FROM projetos WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a projeto" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement);
        }
    }

    public List<Projeto> getAll() {
        String sql = "SELECT * FROM projetos";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Projeto> projetos = new ArrayList<>();

        try {
            connection = ConnectioFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Projeto projeto = new Projeto();
                projeto.setId(resultSet.getInt("id"));
                projeto.setNome(resultSet.getString("nome"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setDataCriacao(resultSet.getDate("data_criacao"));
                projeto.setDataAtualizacao(resultSet.getDate("data_atualizacao"));

                projetos.add(projeto);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao consultar a projeto" + ex.getMessage(), ex);
        } finally {
            ConnectioFactory.closeConnection(connection, statement, resultSet);
        }
        return projetos;
    }
}
