package com.ifpb.login.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://localhost:5432/Login";
        String usuario = "postgres";
        String senha = "postgres";
        
        return DriverManager.getConnection(url, usuario, senha);
        
    }
    
}
