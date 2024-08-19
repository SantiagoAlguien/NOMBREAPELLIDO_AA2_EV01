package org.example;

import com.utils.DatabaseOperations;
import com.utils.models.Prueba;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DatabaseOperations dbOps = new DatabaseOperations();

        // Crear una nueva conexión
        try (Connection connection = dbOps.getConnection()) {
            if (connection != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");

                // Insertar un nuevo registro
                Prueba newPrueba = new Prueba(3, "john_doe", "password123");
                dbOps.insertPrueba(connection, newPrueba);

                // Consultar registros
                List<Prueba> pruebas = dbOps.getPruebas(connection);
                pruebas.forEach(prueba -> System.out.println(prueba));

                // Actualizar un registro
                newPrueba.setPassword("newpassword123");
                dbOps.updatePrueba(connection, newPrueba);

                // Eliminar un registro
                dbOps.deletePrueba(connection, 2);
            } else {
                System.out.println("Fallo en la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
