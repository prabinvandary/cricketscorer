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
public interface PlayerService {

    Boolean savePlayer(DashboardController dashboardController, Player player);

    List<Player> getAllPlayerDetais(DashboardController dashboardController);

    List<Player> getAllFromList(DashboardController dashboardController);

    Player getPlayerById(DashboardController dashboardController, Integer id);

    Boolean deletePlayerById(DashboardController dashboardController, Integer id);

    Boolean updatePlayerById(DashboardController dashboardController, Player player);

    Boolean deleteById(DashboardController dashboardController, Integer id);

    Boolean updatePlayerByIdLocalRepository(DashboardController dashboardController, Player player);

    List<Player> getAllFromDatabase(DashboardController dashboardController);

    Player getPlayerByIdFromDatabase(DashboardController dashboardController, Integer id);

}
