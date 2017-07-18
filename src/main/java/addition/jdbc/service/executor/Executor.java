package addition.jdbc.service.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alterG on 18.07.2017.
 */
public class Executor {
    private final Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String statement) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(statement);
        stmt.close();
    }

    public <T> T execQuery(String query, ResultSetHandler<T> handler) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet resultSet = stmt.getResultSet();
        T value = handler.handle(resultSet);
        resultSet.close();
        stmt.close();
        return value;
    }
}
