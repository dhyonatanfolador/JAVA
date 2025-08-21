package presencial.class_II.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/app?useTimezone=true&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASS = "9148";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
                        
            return DriverManager.getConnection(URL, USER, PASS);
        
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao", ex);
        }
    }
    
    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro =  " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro =  " + ex);
            }
        }
        closeConnection(con);
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro =  " + ex);
            }
        }
        closeConnection(con, stmt);
    } 
}