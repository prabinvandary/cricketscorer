/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.player;

import com.mysql.cj.protocol.Resultset;
import cricscorer.Model.Player;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import cricscorer.repository.generic.genericrepository.GenericRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabin
 */
public class PlayerRepository extends GenericRepository<Player, Integer> {
    
    @Override
    public Integer getId(Player item) {
        return item.getId();
    }
    
    public Boolean savePlayer(DashboardController dashboardController, Player player) {
        
        String insertQuery = "INSERT INTO player(name,player_role,address) VALUES (?, ?,?)";
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, player.getName());
                preparedStatement.setString(2, player.getRole().toString());
                preparedStatement.setString(3, player.getAddress());
                preparedStatement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        return true;
    }
    
    public Player getPlayerById(DashboardController dashboardController, Integer id) {
        String selectQuery = "select * from player p where p.id=?";
        Player player = new Player();
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setInt(1, id);
                ResultSet resultset = preparedStatement.executeQuery();
                if (resultset.next()) {
                    player.setId(resultset.getInt("id"));
                    player.setName(resultset.getString("name"));
                    player.setRole(PlayerRole.valueOf(resultset.getString("player_role")));
                    player.setAddress(resultset.getString("address"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return player;     
    }
    
    
        public Player getAllPlayer(DashboardController dashboardController, Integer id) {
        String selectQuery = "select * from player p where p.id=?";
        Player player = new Player();
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setInt(1, id);
                ResultSet resultset = preparedStatement.executeQuery();
                if (resultset.next()) {
                    player.setId(resultset.getInt("id"));
                    player.setName(resultset.getString("name"));
                    player.setRole(PlayerRole.valueOf(resultset.getString("player_role")));
                    player.setAddress(resultset.getString("address"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return player;     
    }
}
