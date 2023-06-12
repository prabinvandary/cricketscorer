package cricscorer.mysqlconnection;

import java.sql.*;

public class MySqlConnection {

    private Connection con = null;

    public Connection returnConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/cricscorer";
        String userName = "prabin";
        String password = "Prabin12#$%";
        try {
            con = DriverManager.getConnection(url, userName, password);
            Statement stmt = con.createStatement();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
