/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.match;

import cricscorer.mysqlconnection.MySqlConnection;
import java.sql.Connection;
import java.sql.*;
public class MatchRepository {

    String createTableStatement = "create table match(id int primary key auto_increment,matchDate date,venue varchar(255)";

    Boolean createMatchEntity() {
        try {
            MySqlConnection connection = new MySqlConnection();
            Connection con = connection.returnConnection();
            Statement stmt = con.createStatement();
            stmt.execute(createTableStatement);
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }
}
