package Daos;

import Beans.Cancion;
import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;

public class ReproduccionDao {

    public ArrayList<Cancion> listaReproducciones(){
        ArrayList<Cancion> listaReproduccion = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT c.*, COUNT(*) AS total_reproducciones\n" +
                "FROM reproduccion r INNER JOIN cancion c ON (c.idcancion = r.cancion_idcancion)\n" +
                "GROUP BY r.cancion_idcancion\n" +
                "HAVING COUNT(*) > 2\n" +
                "ORDER BY total_reproducciones DESC;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Cancion reproduccion = new Cancion(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3), resultSet.getInt(4));
                /*cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombreCancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));*/
                listaReproduccion.add(reproduccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaReproduccion;

    }
}
