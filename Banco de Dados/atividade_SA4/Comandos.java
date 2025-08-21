package org.atividade_SA4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Comandos {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner sca = new Scanner(System.in);
        System.out.println("\n\n\n\n");
        System.out.println("===================================");
        System.out.println("          MENU DE TABELAS          ");
        System.out.println("===================================");
        System.out.println("1 - ADICIONAR TABELA");
        System.out.println("2 - EDITAR TABELA");
        System.out.println("3 - DELETAR TABELA");
        System.out.println("4 - FECHAR SISTEMA");
        System.out.println("===================================");
        System.out.print("OPCAO: ");
        int opcao = sca.nextInt();

        switch (opcao) {
            case 1:
                novo();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                sair();
                break;
            default:
                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("NAO CONSEGUIMOS TERMINAR A OPERACAO");
                System.out.println("===================================");
                menu();
                break;
        }
    }
    public static void novo() {
        try (Scanner scanner = new Scanner(System.in)) {
            Connection conexao = MySQLConnection.conexao();

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O NOME DA TABELA: ");
            String nome = scanner.nextLine();

            String id = "id_" + nome + " INT PRIMARY KEY AUTO_INCREMENT";

            StringBuilder comando = new StringBuilder("CREATE TABLE " + nome + " ( " + id);

            while (true) {
                System.out.println("\n\n\n");
                System.out.println("===================================");
                System.out.println("  DESEJA ADICIONAR UM NOVO CAMPO?  ");
                System.out.println("       1 - SIM   |   2 - NAO       ");
                System.out.println("===================================");
                System.out.print("OPCAO: ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("2")) {
                    break;
                }

                System.out.println("\n\n\n");
                System.out.print("DIGITE O NOME DO CAMPO: ");
                String campo_nome = scanner.nextLine();
                System.out.print("DIGITE O TIPO DO CAMPO (ex: VARCHAR(255), INT): ");
                String campo_tipo = scanner.nextLine();

                comando.append(", ").append(campo_nome).append(" ").append(campo_tipo);
            }
            comando.append(" );");

            try {
                Statement stmt = conexao.createStatement();
                stmt.executeUpdate(comando.toString());

                System.out.println("\n\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("     TABELA CRIADA COM SUCESSO     ");
                System.out.println("===================================");

            } catch (SQLException e) {
                System.out.println("\n\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("       ERRO AO CRIAR TABELA!       ");
                System.out.println("===================================");
            }

            System.out.print("APERTE 'ENTER' PARA SAIR");
            scanner.nextLine();
            menu();
        }
    }
    public static void update() {
        try (Scanner scanner = new Scanner(System.in)) {
            Connection conexao = MySQLConnection.conexao();

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O NOME DA TABELA: ");
            String nome = scanner.nextLine();
            System.out.print("DIGITE O NOME DO CAMPO A SER ALTERADO: ");
            String campo_antigo = scanner.nextLine();

            System.out.println("\n\n");
            System.out.print("DIGITE O NOVO NOME DO CAMPO: ");
            String campo_novo = scanner.nextLine();
            System.out.print("DIGITE O NOVO TIPO DO CAMPO (ex: VARCHAR(255), INT): ");
            String campo_tipo = scanner.nextLine();

            String comando = "ALTER TABLE " + nome + " CHANGE " +
                    campo_antigo + " " + campo_novo + " " + campo_tipo;
            try {
                Statement stmt = conexao.createStatement();
                stmt.executeUpdate(comando);

                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("    TABELA ALTERADA COM SUCESSO    ");
                System.out.println("===================================");

            } catch (SQLException e) {
                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("       ERRO AO ALTERAR TABELA!     ");
                System.out.println("===================================");
            }

            System.out.print("APERTE 'ENTER' PARA SAIR");
            scanner.nextLine();
            menu();
        }
    }
    public static void delete() {
        try (Scanner scanner = new Scanner(System.in)) {
            Connection conexao = MySQLConnection.conexao();

            System.out.println("\n\n\n\n\n");
            System.out.println("=================================");
            System.out.print("DIGITE O NOME DA TABELA: ");
            String nome = scanner.nextLine();

            String comando = "DROP TABLE " + nome;

            try {
                Statement stmt = conexao.createStatement();
                stmt.executeUpdate(comando);

                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("    TABELA EXCLUIDA COM SUCESSO    ");
                System.out.println("===================================");

            } catch (SQLException e) {
                System.out.println("\n\n\n\n");
                System.out.println("=============!ATENCAO!=============");
                System.out.println("       ERRO AO EXCLUIR TABELA!     ");
                System.out.println("===================================");
            }

            System.out.print("APERTE 'ENTER' PARA SAIR");
            scanner.nextLine();
            menu();
        }
    }
    public static void sair() {
        System.out.println("\n\n\n\n");
        System.out.print("FINALIZANDO O SISTEMA. . .");
    }
}
