package br.ufpb.souleco.bd;

import java.sql.*;

public class Conexao {

    public static Connection getConexao(){
       String url = "jdbc:postgresql://localhost:5432/dbsouleco";
       String usuario = "postgres";
       String senha = "12345";

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, usuario, senha);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection){
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement stnt){
        close(connection);
        try {
            if(stnt != null)
                stnt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement stnt, ResultSet rs){
        close(connection, stnt);
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
