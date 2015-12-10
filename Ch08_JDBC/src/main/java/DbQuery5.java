import utils.DbConnect;
import utils.DbTablePrinter;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * Created by vitaly on 08.12.15.
 */
public class DbQuery5 {
    public static void main(String[] args) {
        try {
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
            rowSet.setUrl(DbConnect.dbUrl + DbConnect.dbName);
            rowSet.setUsername(DbConnect.userName);
            rowSet.setPassword(DbConnect.password);
            rowSet.setCommand("select * from contact");
            rowSet.execute();

            System.out.println("id \tfName \tlName \temail \t\tphoneNo");
            while (rowSet.next()) {
                System.out.println(rowSet.getInt("id") + "\t"
                        + rowSet.getString("firstName") + "\t"
                        + rowSet.getString("lastName") + "\t"
                        + rowSet.getString("email") + "\t"
                        + rowSet.getString("phoneNo"));
            }
//            DbTablePrinter.printResultSet(rowSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

