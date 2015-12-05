import utils.DbConnect;
import utils.DbTablePrinter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 05.12.15.
 */
public class DbInsert {
    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DbConnect.getConnection();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM contact")
        ) {
            System.out.println("Result set before insert");
            DbTablePrinter.printResultSet(resultSet);

            //Inserting new row
            resultSet.moveToInsertRow();
            resultSet.updateString("firstName", "John");
            resultSet.updateString("lastName", "K.");
            resultSet.updateString("email", "john@abc.com");
            resultSet.updateString("phoneNo", "+19753186420");
            resultSet.insertRow();

            //reseting the cursor
            resultSet.beforeFirst();
            System.out.println("Result set after insert");
            DbTablePrinter.printResultSet(resultSet);
        }
    }
}
