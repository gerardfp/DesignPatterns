package singleton.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class ConnectionPool {
    private static ConnectionPool instance;
    private List<Connection> connectionPool = new ArrayList<>();
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String user = "myuser";
    private String password = "mypassword";
    private int poolSize = 10;

    private ConnectionPool() throws SQLException {
        for (int i = 0; i < poolSize; i++) {
            connectionPool.add(DriverManager.getConnection(url, user, password));
        }
    }

    public static synchronized ConnectionPool getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            return null;
        }
        Connection connection = connectionPool.remove(0);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }
}

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection1 = pool.getConnection();

        // perform database operation using connection1

        pool.releaseConnection(connection1);

        Connection connection2 = pool.getConnection();

        // perform another database operation using connection2

        pool.releaseConnection(connection2);
    }
}
