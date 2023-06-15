package cricscorer.controller.dashboard;

import java.sql.SQLException;
import java.util.Scanner;


public class MainDashboardController {

    DashboardController dashboardController;

    public MainDashboardController(DashboardController dashboardController) {
        dashboardController = this.dashboardController;
    }

    public MainDashboardController() {
        dashboardController = new DashboardController();
    }

    public Boolean returnDashboard() throws AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        System.out.println("Hello welcome to the  cric scorer system.");
        System.out.println("How can i assit you??\n Availale services are:"
                + "\n 1.Add Match Entries   2.Update Entities      3.Create Entities"
                + "     4.View statistics and Details       5.To delete Data\n");
        System.out.println(" Enter the respective numbers to access the menus:");
        Scanner sc = new Scanner(System.in);
        Integer menuNumber = sc.nextInt();
        dashboardSwitching(menuNumber);
        return true;
    }

    private void dashboardSwitching(Integer menuNumber) throws AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        switch (menuNumber) {
            case 1:
                dashboardController.getMatchDashboardController().returnAddMatchDashboard(dashboardController);
                break;
            case 2:
                dashboardController.getUpdateEntitiesDashboard().returnUpdateEntitesDashboard(dashboardController);
                break;
            case 3:
                dashboardController.getCreateEntitiesDashboard().returnCreateEntitiesDashboard(dashboardController);
                break;
            case 4:
                dashboardController.getViewStatisticsDashboard().returnViewStatisticsDashboard(dashboardController);
                break;
                case 5:
                dashboardController.getDeleteDashboard().returnDashboard(dashboardController);
                break;
            default:
                returnDashboard();
        }
    }
}
