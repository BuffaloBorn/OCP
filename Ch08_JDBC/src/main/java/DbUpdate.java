import utils.DbConnect;
import utils.DbTablePrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 05.12.15.
 */
public class DbUpdate {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnect.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * FROM contact");) {

            System.out.println("Data before update:");
            DbTablePrinter.printResultSet(resultSet);
            resultSet.absolute(1);
            resultSet.updateString("phoneNo", "+919976543210");
            resultSet.updateRow();
            System.out.println("Data after update:");
            resultSet.beforeFirst();
            DbTablePrinter.printResultSet(resultSet);
        }

    }
}
