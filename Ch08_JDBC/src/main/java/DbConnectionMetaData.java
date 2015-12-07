import utils.DbConnect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Created by vitaly on 07.12.15.
 */
public class DbConnectionMetaData {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnect.getConnection()) {
            DatabaseMetaData metaDate = connection.getMetaData();
            System.out.println("Displaying some of database metadata from the Connection object...");
            System.out.printf("Database is: %s v. %s%n", metaDate.getDatabaseProductName(), metaDate.getDatabaseProductVersion());
            System.out.printf("Driver is: %s v. %s%n", metaDate.getDriverName(), metaDate.getDriverVersion());
            System.out.printf("The URL for this connection is: %s%n", metaDate.getURL());
            System.out.printf("User name is: %s%n", metaDate.getUserName());
            System.out.printf("Maximun no. of rows you can insert is: %s%n", metaDate.getMaxRowSize());
        }
    }

}
