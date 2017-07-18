package addition.jdbc.service.dao;

import addition.jdbc.service.dataset.UserDataSet;
import addition.jdbc.service.executor.Executor;
import addition.jdbc.service.executor.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alterG on 18.07.2017.
 */
public class UsersDAO {
    private Executor executor;

    public UsersDAO(Connection connection) {
        executor = new Executor(connection);
    }

    public UserDataSet getUser(long id) throws SQLException {
        ResultSetHandler<UserDataSet> handler = (resultSet) -> {
            resultSet.next();
            long tableId = resultSet.getLong(1);
            String name = resultSet.getString(2);
            UserDataSet result = new UserDataSet(tableId, name);
            return result;
        };
        String query = "select * from users where id="+id;
        UserDataSet result = executor.execQuery(query, handler);
        return result;
    }

    public long getUserId(String name) throws SQLException {
        String query = "select * from users where user_name='"+name+"'";
        long userId = executor.execQuery(query, (resultSet -> {
            resultSet.next();
            return resultSet.getLong(1);
        }));
        return userId;
    }

    public void insertUser(String name) throws SQLException {
        String stmt = "insert into users (user_name) values ('" + name + "')";
        executor.execUpdate(stmt);
    }

    public void createTable() throws SQLException {
        String stmt = "create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))";
        executor.execUpdate(stmt);
    }

    public void dropTable() throws SQLException {
        String stmt = "drop table users";
        executor.execUpdate(stmt);
    }
}
