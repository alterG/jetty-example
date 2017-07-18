package addition.jdbc.service.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Functional interface for executor correctly work
 * Pattern provides getting result of specified data type
 * Created by alterG on 18.07.2017.
 */
public interface ResultSetHandler<T> {
    T handle (ResultSet resultSet) throws SQLException;
}
