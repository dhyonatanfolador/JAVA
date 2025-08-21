package org.banco_de_dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {

        Connection conexao = MySQLConnection.conexao();

        String comando = "SELECT * FROM usuario";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(comando);

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");

                System.out.println("Nome: " + nome + "\nEmail: " + email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
