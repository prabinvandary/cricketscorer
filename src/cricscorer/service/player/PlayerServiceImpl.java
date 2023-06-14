/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.player;

import cricscorer.Model.Player;
import cricscorer.controller.dashboard.DashboardController;
import java.util.List;

/**
 *
 * @author prabin
 */
public class PlayerServiceImpl implements PlayerService {

    @Override
    public Boolean savePlayer(DashboardController dashboardController, Player player) {
        dashboardController.getPlayerRepository().savePlayer(dashboardController, player);
        return true;
    }

    @Override
    public List<Player> getAllPlayerDetais(DashboardController dashboardController) {
       return dashboardController.getPlayerRepository().getAllPlayer(dashboardController);
    }

    @Override
    public Player getPlayerById(DashboardController dashboardController, Integer id) {
        return dashboardController.getPlayerRepository().getPlayerById(dashboardController, id);
    }

}
