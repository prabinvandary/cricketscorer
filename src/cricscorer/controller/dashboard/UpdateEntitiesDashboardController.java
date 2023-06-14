package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;

/**
 *
 * @author prabin
 */
public class UpdateEntitiesDashboardController {

    PlayerController playerController = new PlayerController();

   public void returnUpdateEntitesDashboard(DashboardController dashboardController) {
        System.out.println("Welcome to delete dashboard:");
        deletePlayerById(dashboardController);
    }

    
    public Boolean deletePlayerById(DashboardController dashboardController) {
        return playerController.deletePlayerById(dashboardController);
    }

}
