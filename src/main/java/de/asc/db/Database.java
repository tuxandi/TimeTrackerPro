package de.asc.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/timetracker";
        String user = "time";
        String password = "jonas";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
               
                //System.out.println(rs.getString(6));
            }

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(Connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}