package OCP;

import java.sql.*;

/**
 * Created by Vitaly on 09.08.2016.
 */
public class MyFirstDatabaseConnection {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/zoo?user=root&password=415263")) {
            Statement smt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = smt.executeQuery("SELECT NAME FROM animal");
//            while (rs.next()) {
            rs.next();
            rs.previous();
            rs.previous();
//            printName(rs, 2);
//            printName(rs, 1);
//            printName(rs, -2);
//                Date date = rs.getDate(1);
//                date.toLocalDate();
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printName(ResultSet rs, int index) throws SQLException {
//        rs.absolute(index);
//        rs.relative(index);
        rs.last();
        rs.previous();
        System.out.println(rs.getString("NAME"));
    }
}
