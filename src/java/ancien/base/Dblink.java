package base;

import java.sql.*;

public class Dblink {
    public static Connection mysqlConnect () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/cin","root","");

//        Statement statement = co.createStatement();
//        co.close();
        return co;
    }

    public static Connection oracleConnect () throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","nicolas","root");

//        Statement statement = co.createStatement();
//        co.close();
        return co;
    }

    public static Connection postgresConnect() {

        Connection co = null;
        try {
            Class. forName("org.postgresql.Driver");
            co = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetmeuble","postgres","root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return co;
    }

    public static void querry(String sql) throws ClassNotFoundException {
        System.out.println(sql);
        Connection connection = null;
        Statement statement = null;
        try {
            connection = mysqlConnect();
            statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            try {
                connection.close();
                statement.close();
                connection = postgresConnect();
                statement = connection.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException ex) {
                try {
                    connection.close();
                    statement.close();
                    connection = oracleConnect();
                    statement = connection.createStatement();
                    statement.executeUpdate(sql);

                    statement.close();
                    connection.close();
                } catch (SQLException exc) {
                    throw new RuntimeException(exc);
                }
            }

        }
    }

    public static void querry(Connection c,String sql) throws ClassNotFoundException {
        System.out.println(sql);
        Statement statement = null;
        try {
            statement = c.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
