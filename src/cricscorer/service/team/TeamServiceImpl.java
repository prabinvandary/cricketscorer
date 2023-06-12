/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.team;

import cricscorer.Model.Team;
import cricscorer.mysqlconnection.MySqlConnection;
import java.util.List;
import java.sql.*;

/**
 *
 * @author prabin
 */
public class TeamServiceImpl implements TeamService {

    @Override
    public Boolean saveTeam(Team team) {

        try {
            MySqlConnection connection = new MySqlConnection();
            Connection con=connection.returnConnection();            
            PreparedStatement stmt=con.prepareStatement("insert in to team(name,address,manager) values (?,?,?)");
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getAddress());
            stmt.setString(3, team.getManager());
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }

    @Override
    public List<Team> getAllTeams() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Team getTeamById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
