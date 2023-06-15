package cricscorer.controller.dashboard;

import cricscorer.controller.PlayerController;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateEntitiesDashboardController {

    Scanner sc = new Scanner(System.in);
    PlayerController playerController = new PlayerController();
    UpdateEntitiesDashboardController updateEntitiesDashboardController = new UpdateEntitiesDashboardController();

    public Boolean returnCreateEntitiesDashboard(DashboardController dashboardController) {
        System.out.println("Welcome to the dashboard to create entites:");
        System.out.println("Enter 1. For Player 2. For Team 3. For Tournament:");
        Integer menuNumber = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        returnMenuDashboard(menuNumber, dashboardController);
        return true;
    }

    private void returnMenuDashboard(Integer menuNumber, DashboardController dashboardController) {
        switch (menuNumber) {
            case 1:
                playerController.savePlayer(dashboardController);
               
            {
                try {
                    new MainDashboardController(dashboardController).returnDashboardFor(dashboardController);
                } catch (NoSuchFieldException | NumberFormatException | SQLException ex) {
                    Logger.getLogger(CreateEntitiesDashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            default:
                throw new AssertionError();
        }

    }
}
