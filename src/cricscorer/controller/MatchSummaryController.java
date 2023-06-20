/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.controller;

import cricscorer.Model.MatchSummary;
import cricscorer.Util.CalculateRunRate;
import cricscorer.enumvalues.MatchBowlAction;
import cricscorer.pojo.TeamScoreDetailPojo;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import cricscorer.service.matchsummary.MatchSummaryService;
import cricscorer.service.matchsummary.MatchSummaryServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class MatchSummaryController {

    CalculateRunRate runRate = new CalculateRunRate();
    Integer teamScore = 0;
    Integer ball = 0;
    Integer wicket = 0;
    Integer id = 1;
    Integer ballRun = 0;
    Double over = 0.0;
    MatchBowlAction matchBowlAction = null;

    private final MatchSummaryService matchSummaryService;

    public MatchSummaryController() {
        this.matchSummaryService = new MatchSummaryServiceImpl();
    }
    Scanner sc = new Scanner(System.in);

    public TeamScoreDetailPojo saveMatchSummary(MatchSummaryRepository matchSummaryRepository, Integer matchId, Integer teamId) throws NumberFormatException, SQLException {
        System.out.println("Let's start the match and enter the each balls details:\n Are you ready??");
        overFunctionality(matchSummaryRepository, matchId);
        TeamScoreDetailPojo teamScoreDetailPojo = new TeamScoreDetailPojo(teamId, teamScore);
        teamScore = 0;
        ball = 0;
        wicket = 0;
        id = 1;
        ballRun = 0;
        over = 0.0;
        matchBowlAction = null;
        return teamScoreDetailPojo;
    }

    private void overFunctionality(MatchSummaryRepository matchSummaryRepository,
            Integer matchId) throws NumberFormatException, SQLException {
        teamScore = 0;
        over = 0.0;
        wicket = 0;
        while (over < 1.0) {
            System.out.println("Enter bowler id:");
            Integer bowlerId = sc.nextInt();
            if (ballFunctionality(bowlerId, matchSummaryRepository, matchId)) {
                return;
            }
            if (wicket == 10) {
                return;
            }
            ball = 0;
            System.out.println("Here's the update after " + over + ":\n");
            System.out.println("Over:" + over);
            System.out.println("Run:" + teamScore);
            System.out.println("Run Rate:" + runRate.calculateRunRate(teamScore, over));
        }
        over = 0.0;
    }

    private boolean ballFunctionality(Integer bowlerId, MatchSummaryRepository matchSummaryRepository, Integer matchId) throws NumberFormatException, SQLException {
        while (ball < 6) {
            System.out.println("Enter batsmen id:");
            Integer batsMenId = sc.nextInt();
            System.out.println("Enter the ball action:\n 1.For Six \t"
                    + "2.For Four \t 3.For Wicket \t 4.For No Ball \t "
                    + "5.For Wide \t 6.For Running between the wickets");
            Integer ballAction = sc.nextInt();
            matchBowlActionTrack(ballAction, batsMenId, bowlerId);
            String decimalPart = String.format("%.1f", (over - over.intValue()));
            if (decimalPart.endsWith("0.6")) {
                over = Math.floor(over) + 1;
            }
            matchSummaryService.saveMatchSummary(matchSummaryRepository, new MatchSummary(id,
                    ballRun, over, matchBowlAction, batsMenId, bowlerId, matchId));
            matchSummaryService.insertDataToDatabase(new MatchSummary(id,
                    ballRun, over, matchBowlAction, batsMenId, bowlerId, matchId), matchSummaryRepository);
            teamScore = teamScore + ballRun;
            id++;
            if (wicket == 10) {
                return true;
            }
        }
        return false;
    }

    private void matchBowlActionTrack(Integer ballAction, Integer batsMenId,
            Integer bowlerId) throws NumberFormatException {
        switch (ballAction) {
            case 1:
                matchBowlAction = MatchBowlAction.SIX;
                ballRun = 6;
                over = Double.valueOf(String.format("%.1f", over + 0.1));
                System.out.println("And it's on the air and out of the "
                        + "boundary for six by batsmen:" + batsMenId);
                ball++;
                break;
            case 2:
                matchBowlAction = MatchBowlAction.FOUR;
                ballRun = 4;
                ball++;
                System.out.println("And it's on the air one drop and out"
                        + " of the boundary for four by batsmen:" + batsMenId);
                over = Double.valueOf(String.format("%.1f", over + 0.1));
                break;
            case 3:
                matchBowlAction = MatchBowlAction.WICKET;
                ball++;
                over = Double.valueOf(String.format("%.1f", over + 0.1));
                System.out.println("And it's a wicket and " + batsMenId + " "
                        + "went to the  pavilion by " + bowlerId);
                wicket++;
                break;
            case 4:
                matchBowlAction = MatchBowlAction.NO_BALL;
                ballRun = 1;
                System.out.println("It's a no ball and one run to the "
                        + "batting team and bowler has to bowl again.");
                break;
            case 5:
                matchBowlAction = MatchBowlAction.WIDE;
                System.out.println("It's a wide and one run extra to "
                        + "the batting team.s");
                ballRun = 1;
                break;
            case 6:
                matchBowlAction = MatchBowlAction.RUNNING_BETWEEN_THE_WICKETS;
                System.out.println("Run taken:");
                ballRun = sc.nextInt();
                ball++;
                over = Double.valueOf(String.format("%.1f", over + 0.1));
                System.out.println(batsMenId + "took " + ballRun + " by interestingly");
                break;
            default:
                break;
        }
    }

}
