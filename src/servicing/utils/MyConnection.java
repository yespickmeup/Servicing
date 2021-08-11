/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicing.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i1
 */
public class MyConnection {

    private MyConnection() {
    }
    private static MyConnection connection;

    private static void init() {
        if (connection == null) {
            connection = new MyConnection();
        }
    }
    private static Connection conn;
    static String hosts = "localhost:3306";

    public static Connection connect() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String db_name = System.getProperty("pool_db", "db_algorithm");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection connect3() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String db_name = System.getProperty("mydb", "db_dtr");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name;

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static Connection connect2() {
        try {
            //        init();
            String host = System.getProperty("pool_host", "localhost:3306");
            String user = System.getProperty("pool_user", "root");
            String password = System.getProperty("pool_password", "password");
            String db_name = System.getProperty("mydb", "db_dtr");
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/";

            try {
                conn = DriverManager.getConnection(url, user, password);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void close() {
        if (conn != null) {
            try {
                conn.close();

                conn = null;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        connect();
    }

    public static int check_cloud_connection() {

        int connected = 0;
        String host = System.getProperty("cloud_host", "128.199.80.53");
        String port = System.getProperty("cloud_port", "3306");
        host = host + ":" + port;
        String user = System.getProperty("cloud_user", "smis2");
        String password = System.getProperty("cloud_password", "nopassword101");
        String db_name = System.getProperty("cloud_db", "db_algorithm");
        System.out.println("Connecting to cloud....");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + "/" + db_name + "?autoReconnect=true&zeroDateTimeBehavior=convertToNull&connectTimeout=10000&socketTimeout=30000";
//            System.out.println("Url: "+url);
//            System.out.println("User: "+user);
//            System.out.println("Password: "+password);
            try {
                Connection conn1 = DriverManager.getConnection(url, user, password);
                String s0 = "select "
                        + " id"
                        + ",user_name"
                        + " from users"
                        + " limit 1";
                Statement stmt = conn1.createStatement();
                ResultSet rs = stmt.executeQuery(s0);
                if (rs.next()) {
//                    System.out.println(rs.getString(2));
                    connected = 1;
                }
            } catch (SQLException ex) {
//                System.out.println(ex);
                return 0;
            }
        } catch (ClassNotFoundException ex) {
            return 0;
        }
        return connected;

    }

    public static Connection cloud_connect() {

        Connection conn3 = null;
        try {
            //        init();

            String host = System.getProperty("cloud_host", "128.199.80.53");
            String port = System.getProperty("cloud_port", "3306");
            host = host + ":" + port;
            String user = System.getProperty("cloud_user", "smis2");
            String password = System.getProperty("cloud_password", "nopassword101");
            String db_name = System.getProperty("cloud_db", "db_algorithm");
            System.out.println("Connecting to cloud....");
            try {

                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://" + host + "/" + db_name + "?autoReconnect=true&zeroDateTimeBehavior=convertToNull&connectTimeout=100000&socketTimeout=300000";
//                String url = "jdbc:mysql://" + host + "/" + db_name + ""; &connectTimeout=10000&socketTimeout=30000

                conn3 = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established!");
//                conn2.setNetworkTimeout(Executors.newFixedThreadPool(1), 1000);
                //DriverManager.getConnection("proxool.pool_connection");
            } catch (SQLException ex) {
                System.out.println("Unable to connect!");
                Logger.getLogger(MyConnection.class.getName()).
                        log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(MyConnection.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return conn3;
    }

    public static void exec_cloud_query(List<String> query) {
        try {
            Connection cloud = MyConnection.cloud_connect();
            cloud.setAutoCommit(false);
            System.out.println("Preparing to execute command...");
            PreparedStatement stmt = cloud.prepareStatement("");
            for (String s : query) {

                stmt.addBatch(s);

            }
            stmt.executeBatch();
            cloud.commit();
            System.out.println("Successfully executed!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
