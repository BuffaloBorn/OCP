import utils.DbConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 05.12.15.
 */
public class DbCreateTable {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbConnect.getConnection();
             Statement statement = connection.createStatement()
        ) {
            // use CREATE TABLE SQL statement to create table familyGroup
            boolean result = statement.execute("CREATE TABLE familyGroup (id int not  null auto_increment, nickName varchar(30) not null, primary key(id));");
            System.out.println("Table created successfully");
        }
    }
}

