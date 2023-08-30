package com.loja.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
        statement.setInt(1, 2);
        statement.execute();

        int linhasModificadas = statement.getUpdateCount();
        System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);

        connection.close();
    }
}
