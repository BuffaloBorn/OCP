package OCP;

import java.sql.*;

/**
 * Created by Vitaly on 09.08.2016.
 */
public class SetupDerbyDatabase {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost/zoo";
        try (Connection conn = DriverManager.getConnection(url, "root", "415263");
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE SCHEMA IF NOT  EXISTS zoo");
            stmt.executeUpdate("CREATE TABLE IF NOT  EXISTS species (id INTEGER PRIMARY KEY, name VARCHAR(255), num_acres DECIMAL)");
            stmt.executeUpdate("CREATE TABLE IF NOT  EXISTS animal (id INTEGER PRIMARY KEY, species_id integer, name VARCHAR(255), date_born TIMESTAMP)");
            stmt.executeUpdate("INSERT INTO pecies VALUES (1, 'African Elephant', 7.5)");
            stmt.executeUpdate("INSERT INTO pecies VALUES (2, 'Zebra', 1.2)");
            stmt.executeUpdate("INSERT INTO nimal VALUES (1, 1, 'Elsa', '2001-05-06 02:15')");
            stmt.executeUpdate("INSERT INTO nimal VALUES (2, 2, 'Zelda', '2002-08-15 09:12')");
            stmt.executeUpdate("INSERT INTO nimal VALUES (3, 1, 'Ester', '2002-09-09 10:36')");
            stmt.executeUpdate("INSERT INTO nimal VALUES (4, 1, 'Eddie', '2010-06-08 01:24')");
            stmt.executeUpdate("INSERT INTO nimal VALUES (5, 2, 'Zoe', '2005-11-12 03:44')");
        }


    }
}