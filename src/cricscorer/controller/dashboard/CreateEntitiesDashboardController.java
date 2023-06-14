package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;
import java.util.Scanner;

public class CreateEntitiesDashboardController {

    Scanner sc = new Scanner(System.in);
    PlayerController playerController = new PlayerController();

    public Boolean returnCreateEntitiesDashboard(DashboardController dashboardController) {
        System.out.println("Welcome to the dashboard to create entites:");
        System.out.println("Enter 1. For Player 2. For Team 3. For Tournament:");
        Integer menuNumber = sc.nextInt();
        returnMenuDashboard(menuNumber, dashboardController);
        return true;
    }

    private void returnMenuDashboard(Integer menuNumber, DashboardController dashboardController) {
        switch (menuNumber) {
            case 1:
                playerController.savePlayer(dashboardController);
                break;
            default:
                throw new AssertionError();
        }

    }
}
