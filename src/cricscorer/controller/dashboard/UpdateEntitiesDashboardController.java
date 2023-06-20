package cricscorer.controller.dashboard;

import cricscorer.controller.MatchController;
import cricscorer.controller.PlayerController;
import cricscorer.controller.TeamController;
import cricscorer.controller.TournamentController;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class UpdateEntitiesDashboardController {

    PlayerController playerController = new PlayerController();

    TeamController teamController = new TeamController();

    MatchController matchController = new MatchController();

    TournamentController tournamentController = new TournamentController();
    Scanner sc = new Scanner(System.in);

    public void returnUpdateEntitesDashboard(DashboardController dashboardController) throws AssertionError, AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        System.out.println("Welcome to the Update Entities Dashboard:");
        System.out.println("Enter 1. For Player and 2. For Team   3. For Tournament     4. For Match");
        Integer menuId = sc.nextInt();
        retunMenuWiseDashboard(dashboardController, menuId);
    }

    public Boolean deletePlayerById(DashboardController dashboardController) {
        return playerController.deletePlayerById(dashboardController);
    }

    private Boolean updatePlayerById(DashboardController dashboardController) {
        return playerController.updatePlayerById(dashboardController);
    }

    private void retunMenuWiseDashboard(DashboardController dashboardController, Integer menuId) throws AssertionError, NoSuchFieldException, NumberFormatException, SQLException {
        MainDashboardController mainDashboardController = new MainDashboardController(dashboardController);

        switch (menuId) {
            case 1:
                playerController.getAllList(dashboardController);
                playerController.updatePlayerByIdInLocalRepository(dashboardController);
                playerController.getAllList(dashboardController);
                returnUpdateEntitesDashboard(dashboardController);

                break;
            case 2:
                teamController.updateTeamById(dashboardController);
                returnUpdateEntitesDashboard(dashboardController);

                break;
            case 3:
                tournamentController.updateTournamentById(dashboardController);
                returnUpdateEntitesDashboard(dashboardController);

                break;
            case 4:
                matchController.updateMatchById(dashboardController);
                returnUpdateEntitesDashboard(dashboardController);
                break;
            default:
                new MainDashboardController().returnDashboardFor(dashboardController);
        }
    }

}
