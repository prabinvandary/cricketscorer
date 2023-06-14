package cricscorer.controller;

import cricscorer.Model.TeamMatchScore;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TeamController {

    Scanner sc = new Scanner(System.in);

    public String getTeamName() {
        return "Dare devils";
    }

    Boolean getTeamStatistics(DashboardController dashboardController) {

        System.out.println("Enter team id to see it's statistics:");
        Integer id = sc.nextInt();
        List<TeamMatchScore> teamMatchScoreList = dashboardController.getTeamMatchScoreRepository().getAllData();
        List<TeamMatchScore> teamMatchScoreListById = new ArrayList<>();
        for (TeamMatchScore teamMatchScore : teamMatchScoreList) {
            if (Objects.equals(teamMatchScore.getTeamId(), id)) {
                teamMatchScoreListById.add(teamMatchScore);
            }
        }
        System.out.println("Id\t\tTeam Id\t\tMatch Id \t\tScore\t\t Is Winner \t\t Toss Action");
        System.out.println("Hello");

        for (TeamMatchScore teamMatchScore : teamMatchScoreListById) {
            System.out.print(teamMatchScore.getId() + "\t\t" + teamMatchScore.getTeamId()
                    + "\t\t" + teamMatchScore.getMatchId() + "\t\t" + teamMatchScore.getScore() + "\t\t"
                    + teamMatchScore.getIsWinner() + "\t\t" + teamMatchScore.getTossAction());
            System.out.println("\n");
        }
        return true;
    }
}
