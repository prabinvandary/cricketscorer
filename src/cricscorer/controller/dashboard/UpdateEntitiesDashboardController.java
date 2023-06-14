package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class UpdateEntitiesDashboardController {

    PlayerController playerController = new PlayerController();

    Scanner sc = new Scanner(System.in);

    public void returnUpdateEntitesDashboard(DashboardController dashboardController) {
        System.out.println("Welcome to the dashboard:");
        System.out.println("Enter 1. for Delete and 2. For Update");
        Integer menuId = sc.nextInt();
        retunMenuWiseDashboard(dashboardController, menuId);
    }

    public Boolean deletePlayerById(DashboardController dashboardController) {
        return playerController.deletePlayerById(dashboardController);
    }

    private Boolean updatePlayerById(DashboardController dashboardController) {
        return playerController.updatePlayerById(dashboardController);
    }
    private void retunMenuWiseDashboard(DashboardController dashboardController, Integer menuId) {
        switch (menuId) {
            case 1:
                deletePlayerById(dashboardController);
                break;
                case 2:
                    updatePlayerById(dashboardController);
                break;
            default:
                throw new AssertionError();
        }
    }

}
