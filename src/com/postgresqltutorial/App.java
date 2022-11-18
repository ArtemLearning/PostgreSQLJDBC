package com.postgresqltutorial;

import java.sql.*;

public class App {

    public Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost/jaegers";
            String user = "postgres";
            String password = "postgres";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void getJaegers() {

        String SQL = "SELECT * FROM jaegers";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayJaegers(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void displayJaegers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("id") + "\t" +
                               rs.getString("modelName") + "\t" +
                               rs.getString("mark") + "\t" +
                               rs.getString("height") + "\t" +
                               rs.getString("weight") + "\t" +
                               rs.getString("status") + "\t" +
                               rs.getString("origin") + "\t" +
                               rs.getString("launch") + "\t" +
                               rs.getString("kaijuKill"));
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.getJaegers();
    }
}
