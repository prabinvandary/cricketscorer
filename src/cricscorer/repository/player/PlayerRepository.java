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
import java.util.ArrayList;
import java.util.List;
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

    public List<Player> getAllPlayer(DashboardController dashboardController) {
        String selectQuery = "select * from player p";
        List<Player> player = new ArrayList<>();
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(selectQuery);

                ResultSet resultset = preparedStatement.executeQuery();
                if (resultset != null) {
                    while (resultset.next()) {
                        Player singlePlayer = new Player();
                        singlePlayer.setId(resultset.getInt("id"));
                        singlePlayer.setName(resultset.getString("name"));
                        singlePlayer.setRole(PlayerRole.valueOf(resultset.getString("player_role")));
                        singlePlayer.setAddress(resultset.getString("address"));
                        player.add(singlePlayer);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return player;
    }

    public Boolean deleteById(DashboardController dashboardController, Integer id) {
        String deleteQuery = "delete  from player  where id=?";
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return true;
    }

    public Boolean updatePlayer(DashboardController dashboardController, Player player) {

        String updateQuery = "update player  set name=?, player_role=?, address=? where id=?";
        try {
            Connection connection = dashboardController.getMySqlConnection().returnConnection();
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, player.getName());
                preparedStatement.setString(2, player.getRole().toString());
                preparedStatement.setString(3, player.getAddress());
                preparedStatement.setInt(4, player.getId());

               Integer update= preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return true;
    }
}
