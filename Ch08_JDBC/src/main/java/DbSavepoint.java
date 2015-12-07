import utils.DbConnect;

import java.sql.*;

/**
 * Created by vitaly on 07.12.15.
 */
public class DbSavepoint {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConnect.getConnection();
        boolean autoCommitValue = true;

        try {
            autoCommitValue = connection.getAutoCommit();
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
                System.out.println("Starting to insert rows");

                try (ResultSet rs = statement.executeQuery("SELECT * FROM family_group");) {
                    // first insert
                    rs.moveToInsertRow();
                    rs.updateString("nickName", "Tom");
                    rs.insertRow();
                    System.out.println("Inserted row for Tom");
                    // our first savepoint is here. . .
                    Savepoint firstSavepoint = connection.setSavepoint();

                    // second insert
                    rs.moveToInsertRow();
                    rs.updateString("nickName", "Dick");
                    rs.insertRow();
                    System.out.println("Inserted row for Dick");
                    // our second savepoint is here. . . after we inserted Dick
                    // we can give a string name for savepoint
                    Savepoint secondSavepoint = connection.setSavepoint("SavepointForDick");

                    // third insert resultSet.moveToInsertRow();
                    rs.updateString("nickName", "Harry");
                    rs.insertRow();
                    System.out.println("Inserted row for Harry");
                    // our thrid savepoint is here. . . for "Harry"
                    Savepoint thirdSavepoint = connection.setSavepoint("ForHarry");
                    System.out.println("Table updation complete. . .");

                    // rollback to the state when Dick was inserted;
                    // so the insert for Harry will be lost
                    System.out.println("Rolling back to the state where Tom and Dick were inserted");
                    connection.rollback(secondSavepoint);
                    // commit the changes now and see what happens to the contents of the table
                    connection.commit();
                }


            } catch (SQLException e) {
                System.out.println("Unable to commit transaction.");
                connection.rollback();
                connection.setAutoCommit(true);
                e.printStackTrace();
            }
        } finally {
            if (connection == null) {
                connection.setAutoCommit(autoCommitValue);
                connection.close();
            }
        }
    }
}
