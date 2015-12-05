package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by vitaly on 03.12.15.
 */
public class ResultSetSpliterator implements Spliterator<Tuple> {
    private final ResultSet resultSet;

    public ResultSetSpliterator(ResultSet resultSet) {
        try {
            resultSet.beforeFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.resultSet = resultSet;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Tuple> action) {
        try {
            if (resultSet.next()) {
                Tuple tuple = new ResultSetTuple(resultSet);
                action.accept(tuple);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Spliterator<Tuple> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        try {
            return resultSet.getFetchSize() - resultSet.getRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int characteristics() {
        return 0;
    }
}
