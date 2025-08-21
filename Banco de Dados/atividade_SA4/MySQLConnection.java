package org.atividade_SA4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection conexao() {
        final String URL = "jdbc:mysql://localhost:3306/java";
        final String USER = "root";
        final String PASSWORD = "9148";

        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}
