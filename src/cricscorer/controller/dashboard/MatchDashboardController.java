package cricscorer.controller.dashboard;

import cricscorer.Model.Match;
import cricscorer.Util.GenerateId;
import cricscorer.controller.MatchController;
import cricscorer.controller.MatchSummaryController;
import cricscorer.controller.TeamMatchScoreController;
import cricscorer.pojo.TeamScoreDetailPojo;
import cricscorer.repository.match.MatchRepository;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import cricscorer.service.Match.MatchService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchDashboardController {

    public MatchDashboardController(cricscorer.service.Match.MatchService matchService) {
        this.matchService = matchService;
    }
    List<TeamScoreDetailPojo> teamScoreDetailPojos = new ArrayList<>();

    MatchController matchController = new MatchController();
    Scanner sc = new Scanner(System.in);
    GenerateId generateId = new GenerateId();
    private final MatchService matchService;

    MatchSummaryController matchSummaryController = new MatchSummaryController();

    TeamMatchScoreController teamMatchScoreController = new TeamMatchScoreController();

    public void returnAddMatchDashboard(DashboardController dashboardController) throws NoSuchFieldException, NumberFormatException, SQLException {
        System.out.println("Welcome to the match dashboard!\n");
        System.err.println("Choose 1. to start a new match and 2. For match history:");
        Integer matchMenu = sc.nextInt();
        switch (matchMenu) {
            case 1:
                startNewMatch(dashboardController);
                break;
            case 2:
                matchController.returnMatchHistory(dashboardController);
                ;
            default:
                break;
        }
    }

    private void startNewMatch(DashboardController dashboardController) throws NoSuchFieldException, NumberFormatException, SQLException, SQLException{
        Integer matchId = saveMatchDetails(dashboardController.getMatchRepository());
        List<Integer> teamIds = saveTeamMatchScore(dashboardController.getTeamMatchScoreRepository(), matchId);
        for (Integer id : teamIds) {
            teamScoreDetailPojos.add(saveMatchSummary(dashboardController.getMatchSummaryRepository(), matchId, id));
        }
        updateTeamMatchScore(teamScoreDetailPojos, dashboardController.getTeamMatchScoreRepository(), matchId);
        System.out.println(teamMatchScoreController.getAllTeamMatchScoreDetails(dashboardController.getTeamMatchScoreRepository()));
        returnAddMatchDashboard(dashboardController);
    }

    private Integer saveMatchDetails(MatchRepository matchRepository) {
        System.out.println("\n Enter match date in format of yyyy-mm-dd:");
        String matchDate = sc.next();
        System.out.println("\n Enter match venue:");
        String matchVenue = sc.next();
        return matchService.saveMatch(matchRepository, new Match(
                generateId.returnId(), matchDate, matchVenue));
    }

    private TeamScoreDetailPojo saveMatchSummary(MatchSummaryRepository matchSummaryRepository,
            Integer matchId, Integer teamId) throws NumberFormatException, SQLException {
        return matchSummaryController.saveMatchSummary(matchSummaryRepository, matchId, teamId);
    }

    private List<Integer> saveTeamMatchScore(TeamMatchScoreRepository teamMatchScoreRepository,
            Integer matchId) {
        return teamMatchScoreController.saveTeamMatchScore(teamMatchScoreRepository, matchId);
    }

    private void updateTeamMatchScore(List<TeamScoreDetailPojo> teamScoreDetailPojo,
            TeamMatchScoreRepository teamMatchScoreRepository, Integer matchId) {
        teamMatchScoreController.updateTeamMatchScore(teamScoreDetailPojo, teamMatchScoreRepository, matchId);
    }

    void returnAddMatchDashboardFromContrller(DashboardController dashboardController) throws NoSuchFieldException, NumberFormatException, SQLException {
        System.out.println("Welcome to the match dashboard!\n");
        System.err.println("Choose 1. to start a new match and 2. For match history:");
        Integer matchMenu = sc.nextInt();
        switch (matchMenu) {
            case 1:
                startNewMatch(dashboardController);
                break;
            case 2:
                matchController.returnMatchHistory(dashboardController);
            default:
                break;
        }
    }
}
