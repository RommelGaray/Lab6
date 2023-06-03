package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {

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
                Cancion reproduccion = new Cancion(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
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

    public void favorito(int idCancion, int valor){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        if(valor==0){
            sql = "update cancion set favorito = 1 where idcancion = ?";
        } else{
            sql = "update cancion set favorito = 0 where idcancion = ?";
        }
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql);){
            pstmt.setInt(1,idCancion);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    public ArrayList<Cancion> listaCanciones(){
        ArrayList<Cancion> listaCancion = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Cancion cancion = new Cancion(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                /*cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombreCancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));*/
                listaCancion.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCancion;

    }

    public ArrayList<Cancion> cancionesPorBanda(String banda){
        ArrayList<Cancion> listaCancion = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM cancion where banda=?";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";


        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql);){
            pstmt.setString(1,banda);

            try(ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Cancion cancion = new Cancion(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                /*cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombreCancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));*/
                    listaCancion.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        return listaCancion;

    }

}
