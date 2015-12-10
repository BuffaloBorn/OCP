package utils;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by vitaly on 03.12.15.
 */
public class DbConnect {
    public static String dbUrl = "jdbc:mysql://localhost:3306/";
    public static String dbName = "db_address_book";
    public static String userName = "root";
    public static String password = "415263";

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {


        try {
            Connection connection = DriverManager.getConnection(dbUrl + dbName, userName, password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Tuple> toStream(ResultSet resultSet) {
        return StreamSupport.stream(new ResultSetSpliterator(resultSet), false);
    }
}

