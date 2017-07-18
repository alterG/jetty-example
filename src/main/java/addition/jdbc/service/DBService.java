package addition.jdbc.service;

import addition.jdbc.service.dao.UsersDAO;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by alterG on 17.07.2017.
 */

    @SuppressWarnings("UnusedDeclaration")
public class DBService {
    private final Connection connection;

    public DBService() {
        connection = getH2Connection();
    }



    public void cleanUp() {
        UsersDAO usersDAO = new UsersDAO(connection);
        try {
            usersDAO.dropTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printConnectionInfo() {
        try {
            String databaseProductName = connection.getMetaData().getDatabaseProductName();
            String databaseProductVersion = connection.getMetaData().getDatabaseProductVersion();
            String driverName = connection.getMetaData().getDriverName();
            boolean autoCommit = connection.getAutoCommit();
            System.out.println(String.format("Data base: %s\nData base vers: %s\nDriver name: %s\nAutocommit: %b",
                    databaseProductName, databaseProductVersion, driverName, autoCommit));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // why public? we use it in constructor only
    public Connection getMySqlConnection() {
        try {
            DriverManager.registerDriver((Driver) (Class.forName("com.mysql.jdbc.Driver").newInstance()));
            StringBuilder url = new StringBuilder();
            url
                    .append("jdbc:mysql://")    //db type
                    .append("localhost:")       //host name
                    .append("3306/")            //port
                    .append("db_example?")      //db name
                    .append("user=tully&")      //login
                    .append("password=tully");   //password

            System.out.println("URL:" + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getH2Connection() {
        try {
            String url = "jdbc:h2:./h2db";      //don't now how it works
            String login = "tully";
            String password = "tully";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(login);
            ds.setPassword(password);

            Connection connection = DriverManager.getConnection(url, login, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
