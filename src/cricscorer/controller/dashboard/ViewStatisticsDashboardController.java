package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;
import java.util.Scanner;

public class ViewStatisticsDashboardController {

    PlayerController playerController = new PlayerController();

    Scanner sc = new Scanner(System.in);

    public Boolean returnViewStatisticsDashboard(DashboardController dashboardController) {
        System.out.println("Enter 1 for player by id:\t2.For List of Players");
        Integer menuId = sc.nextInt();
        returnDashboard(dashboardController, menuId);
        return true;
    }

    private Boolean returnDashboard(DashboardController dashboardController, Integer menuId) {
        switch (menuId) {
            case 1:
                playerController.getPlayerById(dashboardController);
                break;
                case 2:
                playerController.getAllPlayer(dashboardController);
                break;
            default:
                throw new AssertionError();
        }
        return  true;

    }
}
