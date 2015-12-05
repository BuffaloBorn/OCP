package utils;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by vitaly on 03.12.15.
 */
public class ResultSetTuple implements Tuple {
    private Map<String, Object> row;
    private Object[] values;


    public ResultSetTuple(ResultSet resultSet) {
        try {
            ResultSetMetaData metadata = resultSet.getMetaData();
            final int columnCount = metadata.getColumnCount();
            row = new HashMap<>(columnCount);
            values = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                final int columnIndex = i + 1;
                final Object value = resultSet.getObject(columnIndex);
                row.put(metadata.getColumnName(columnIndex), value);
                values[i] = value;
            }
        } catch (SQLException e) {
            handleException(e);
        }
    }

    private void handleException(Exception e) {
        throw new RuntimeException(e);
    }

    @SuppressWarnings("unchecked")
    private <T> T getValue(int columnIndex) {
        return (T) values[columnIndex];
    }

    @SuppressWarnings("unchecked")
    private <T> T getValue(String columnLabel) {
        return (T) row.get(columnLabel);
    }

    @Override
    public String getString(int columnIndex) {
        return Objects.toString(getValue(columnIndex));
    }

    @Override
    public boolean getBoolean(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public byte getByte(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public short getShort(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public int getInt(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public long getLong(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public float getFloat(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public double getDouble(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public LocalDate getDate(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public LocalTime getTime(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public LocalDateTime getTimestamp(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public Class<?> getType(int columnIndex) {
        Object value = getValue(columnIndex);
        return value == null ? null : value.getClass();
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) {
        return getValue(columnIndex);
    }

    @Override
    public String getString(String columnLabel) {
        return Objects.toString(getValue(columnLabel));
    }

    @Override
    public boolean getBoolean(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public byte getByte(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public short getShort(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public int getInt(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public long getLong(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public float getFloat(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public double getDouble(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public LocalDate getDate(String columnLabel) {

        Date value = getValue(columnLabel);
        return value.toLocalDate();
    }

    @Override
    public LocalTime getTime(String columnLabel) {
        Time value = getValue(columnLabel);
        return value.toLocalTime();
    }

    @Override
    public LocalDateTime getTimestamp(String columnLabel) {
        Timestamp value = getValue(columnLabel);
        return value.toLocalDateTime();
    }

    @Override
    public BigDecimal getBigDecimal(String columnLabel) {
        return getValue(columnLabel);
    }

    @Override
    public Class<?> getType(String columnLabel) {
        Object value = getValue(columnLabel);
        return value == null ? null : value.getClass();
    }
}
