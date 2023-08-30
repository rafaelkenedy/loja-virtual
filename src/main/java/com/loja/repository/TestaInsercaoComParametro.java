package com.loja.repository;

import java.sql.*;

public class TestaInsercaoComParametro {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.recuperarConexao()) {

            connection.setAutoCommit(false);

            try (PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

                adicionarVariavel("tv", "descricao", statement);
                adicionarVariavel("radio", "descricao", statement);

                connection.commit();

                statement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "Roll back executado");
                connection.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement statement) throws SQLException {
        statement.setString(1, nome);
        statement.setString(2, descricao);

        statement.execute();

        try (ResultSet resultSet = statement.getGeneratedKeys()) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("Id criado: " + id);
            }
        }

    }
}
