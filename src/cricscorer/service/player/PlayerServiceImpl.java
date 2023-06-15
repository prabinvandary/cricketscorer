/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.player;

import cricscorer.Model.Player;
import cricscorer.Util.GenerateId;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import java.util.List;

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

}
