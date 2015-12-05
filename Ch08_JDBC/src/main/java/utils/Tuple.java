package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by vitaly on 03.12.15.
 */
public interface Tuple {
    String getString(int columnIndex);

    boolean getBoolean(int columnIndex);

    byte getByte(int columnIndex);

    short getShort(int columnIndex);

    int getInt(int columnIndex);

    long getLong(int columnIndex);

    float getFloat(int columnIndex);

    double getDouble(int columnIndex);

    LocalDate getDate(int columnIndex);

    LocalTime getTime(int columnIndex);

    LocalDateTime getTimestamp(int columnIndex);

    Class<?> getType(int columnIndex);

    String getString(String columnLabel);

    boolean getBoolean(String columnLabel);

    byte getByte(String columnLabel);

    short getShort(String columnLabel);

    int getInt(String columnLabel);

    long getLong(String columnLabel);

    float getFloat(String columnLabel);

    double getDouble(String columnLabel);

    LocalDate getDate(String columnLabel);

    LocalTime getTime(String columnLabel);

    LocalDateTime getTimestamp(String columnLabel);

    BigDecimal getBigDecimal(int columnIndex);

    BigDecimal getBigDecimal(String columnLabel);

    Class<?> getType(String columnLabel);
}
