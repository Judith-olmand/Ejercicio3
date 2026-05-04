package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement statement = conn.createStatement()){
            System.out.println("Conexión establecida con Oracle."); //Mediante Maven
            String sql = "SELECT * FROM empleado WHERE NOT MOD(id,2)=0 " ;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double salario = resultSet.getDouble("salario");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}