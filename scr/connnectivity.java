package MiniProject_TravelManagementSystem;

import java.sql.*;

public class connnectivity {
    public Connection c;
    public Statement s;

    public connnectivity() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "");

            // Create a statement object
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

