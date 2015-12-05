import utils.DbConnect;
import utils.DbTablePrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 05.12.15.
 */
public class DbDelete {
    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DbConnect.getConnection();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ) {

            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM contact WHERE firstName=\"John\"")) {
                if (resultSet.next()) {
                    resultSet.deleteRow();
                }
            }

            System.out.println("Result set after deleting 'John'");
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")){
                DbTablePrinter.printResultSet(resultSet);
            }
        }
    }
}
