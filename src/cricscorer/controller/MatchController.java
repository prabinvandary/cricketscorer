package cricscorer.controller;

import cricscorer.controller.dashboard.DashboardController;
import cricscorer.controller.dashboard.MainDashboardController;
import cricscorer.controller.dashboard.MatchDashboardController;
import cricscorer.repository.match.MatchRepository;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import cricscorer.service.Match.MatchServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

public class MatchController {

    Scanner sc = new Scanner(System.in);

    public void startNewMatch() {

    }
    TeamController teamController = new TeamController();

    PlayerController playerController = new PlayerController();

    public void returnMatchHistory(DashboardController dashboardController) throws NoSuchFieldException, AssertionError, NumberFormatException, SQLException {
        System.out.println("Welcome to the statistics view page:");
        System.out.println("Enter 1. For Team Statistics\t 2. For Bowler Statistics "
                + "3. For Batsmen Statistics 4.For main menu 5.For Id Statistics");
        Integer menuId = sc.nextInt();

        switch (menuId) {
            case 1:
                teamController.getTeamStatistics(dashboardController);
                returnMatchHistory(dashboardController);
                break;

            case 2:
                playerController.getBowlerStatistics(dashboardController);
                returnMatchHistory(dashboardController);

                break;
            case 3:
                playerController.getBatsMenStatistics(dashboardController);
                returnMatchHistory(dashboardController);
                break;
            case 4:
                new MainDashboardController(dashboardController).returnDashboard();
                break;
            case 5:
                playerController.getStatisicsById(dashboardController);
                returnMatchHistory(dashboardController);
                break;
            default:
                returnMatchHistory(dashboardController);
                break;
        }

    }

}
