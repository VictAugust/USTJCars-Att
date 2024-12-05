package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/locadoraa?serverTimezone=America/Sao_Paulo";
    private static final String USER = "root";
    private static final String PASS = "@root123";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ERROBD = "Erro na conexão com o Banco de Dados: ";

    public static Connection getCon() 
    {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException e) {
            throw new RuntimeException(ERROBD + e);
        }     
            
    }
}
