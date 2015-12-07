import utils.DbConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 07.12.15.
 */
public class DbTransaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnect.getConnection();
        boolean autoCommitValue = true;

        try  {
            autoCommitValue = connection.getAutoCommit();
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
                try (ResultSet rs1 = statement.executeQuery("SELECT * FROM family_group");) {
                    rs1.moveToInsertRow();
                    // updating here. . . but this change will be lost if a rollback happens
                    rs1.updateString("nickName", "Sam Uncle");
                    System.out.println("First table updated. . .");
                    rs1.insertRow();
                }

                try (ResultSet rs2 = statement.executeQuery("SELECT * FROM contact");) {
                    rs2.moveToInsertRow();
                    rs2.updateString("firstName", "Samuel");
//                    rs2.updateString("firstName", "The great Samuel the billionaire from Washington DC");
                    rs2.updateString("lastName", "Uncle");
                    rs2.updateString("email", "sam@abc.com");
                    rs2.updateString("phoneNo", "+119955331100");
                    // updating here. . . but this change will be lost of a rollback happens
                    rs2.insertRow();
                }

                System.out.println("Both tables updated, committing now.");
                // we're committing the changes for both the tables only now
                connection.commit();

            } catch (SQLException e) {
                System.out.println("Unable to commit transaction.");
                connection.rollback();
                connection.setAutoCommit(true);
                e.printStackTrace();
            }
        }finally {
            if (connection == null) {
                connection.setAutoCommit(autoCommitValue);
                connection.close();
            }
        }


    }
}
