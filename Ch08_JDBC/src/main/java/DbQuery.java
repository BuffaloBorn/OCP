import utils.*;

import java.sql.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by vitaly on 03.12.15.
 */
public class DbQuery {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnect.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact");
            ResultSet resultSet = statement.executeQuery();
            DbTablePrinter.printResultSet(resultSet);
        }
    }
}
