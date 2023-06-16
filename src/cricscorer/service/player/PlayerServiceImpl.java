/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.player;

import cricscorer.Model.Player;
import cricscorer.Util.GenerateId;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import cricscorer.repository.generic.genericrepository.GenericRepository;
import cricscorer.repository.player.PlayerRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabin
 */
public class PlayerServiceImpl implements PlayerService {

    @Override
    public Boolean savePlayer(DashboardController dashboardController, Player player) {
        dashboardController.getPlayerRepository().savePlayer(dashboardController, player);
        dashboardController.getPlayerRepository().saveData(new Player(new GenerateId().returnId(), player.getName(), player.getRole(), player.getAddress()));
        return true;
    }

    @Override
    public List<Player> getAllPlayerDetais(DashboardController dashboardController) {
        return dashboardController.getPlayerRepository().getAllPlayer(dashboardController);
    }

    @Override
    public List<Player> getAllFromList(DashboardController dashboardController) {
        return dashboardController.getPlayerRepository().getAllData();
    }

    @Override
    public Player getPlayerById(DashboardController dashboardController, Integer id) {
        return dashboardController.getPlayerRepository().getPlayerById(dashboardController, id);
    }

    @Override
    public Boolean deletePlayerById(DashboardController dashboardController, Integer id) {
        return dashboardController.getPlayerRepository().deleteById(dashboardController, id);
    }

    @Override
    public Boolean updatePlayerById(DashboardController dashboardController, Player player) {
        return dashboardController.getPlayerRepository().updatePlayer(dashboardController, player);
    }

    @Override
    public Boolean deleteById(DashboardController dashboardController, Integer id) {
        return dashboardController.getPlayerRepository().deleteById(id);
    }

    @Override
    public Boolean updatePlayerByIdLocalRepository(DashboardController dashboardController, Player player) {
        dashboardController.getPlayerRepository().updateById(player.getId(), player);
        return true;
    }

    @Override
    public List<Player> getAllFromDatabase(DashboardController dashboardController) {
        List<Player> players = new ArrayList<>();
        ResultSet resultset = dashboardController.getPlayerRepository().getAllDataFromDataBase("player");
        try {
            if (resultset != null) {
                while (resultset.next()) {
                    Player singlePlayer = new Player();
                    singlePlayer.setId(resultset.getInt("id"));
                    singlePlayer.setName(resultset.getString("name"));
                    singlePlayer.setRole(PlayerRole.valueOf(resultset.getString("player_role")));
                    singlePlayer.setAddress(resultset.getString("address"));
                    players.add(singlePlayer);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(GenericRepository.class.getName()).log(Level.SEVERE, null, e);

        }

        return players;
    }

    @Override
    public Player getPlayerByIdFromDatabase(DashboardController dashboardController, Integer id) {
        Player player = new Player();
        try {
            ResultSet resultset = dashboardController.getPlayerRepository().getDataByIdFromDatabase("player", id);
            if (resultset.next()) {
                player.setId(resultset.getInt("id"));
                player.setName(resultset.getString("name"));
                player.setRole(PlayerRole.valueOf(resultset.getString("player_role")));
                player.setAddress(resultset.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return player;

    }

}
