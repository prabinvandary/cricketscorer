package cricscorer.dashboard.addMatchSummaryDashboard;

import cricscorer.Model.MatchSummary;
import cricscorer.enumvalues.MatchBowlAction;
import cricscorer.service.matchsummary.MatchSummaryService;
import java.util.Scanner;

public class AddMatchSummaryDashboard {

    Scanner sc = new Scanner(System.in);
    private final MatchSummaryService matchSummaryService;
    Integer teamScore = 0;
    Double teamOver = 0.0;

    public Double getTeamOver() {
        return teamOver;
    }

    public Integer getTeamScore() {
        return teamScore;
    }

    public void setTeamOver(Double teamOver) {
        this.teamOver = teamOver;
    }

    public void setTeamScore(Integer teamScore) {
        this.teamScore = teamScore;
    }

    public AddMatchSummaryDashboard(MatchSummaryService matchSummaryService, Integer teamScore, Double teamOver) {
        this.matchSummaryService = matchSummaryService;
        this.teamOver = teamOver;
        this.teamScore = teamScore;
    }

    public AddMatchSummaryDashboard() {
        this.matchSummaryService = null;
    }

    public void addMatchSummaryDashboard(Integer matchId) {
        System.out.println("Let's start the match and enter the each balls details:\n Are you ready??");
        Double over = 0.0;
        Integer ball = 0;

        MatchBowlAction matchBowlAction = null;

        while (over < 10.0) {
            System.out.println("Enter bowler id:");
            Integer bowlerId = sc.nextInt();
            while (ball < 6) {
                Integer id = 1;
                Integer ballRun = 0;
                System.out.println("Enter batsmen id:");
                Integer batsMenId = sc.nextInt();
                System.out.println("Enter the ball action:\n 1.For Six \t"
                        + "2.For Four \t 3.For Wicket \t 4.For No Ball \t "
                        + "5.For Wide \t 6.For Running between the wickets");
                Integer ballAction = sc.nextInt();
                switch (ballAction) {
                    case 1:
                        matchBowlAction = MatchBowlAction.SIX;
                        ballRun = 6;
                        over++;
                        break;
                    case 2:
                        matchBowlAction = MatchBowlAction.FOUR;
                        ballRun = 4;
                        ball++;
                        over++;
                        break;
                    case 3:
                        matchBowlAction = MatchBowlAction.WICKET;
                        ball++;
                        over++;
                        break;
                    case 4:
                        matchBowlAction = MatchBowlAction.NO_BALL;
                        ballRun = 1;
                        break;
                    case 5:
                        matchBowlAction = MatchBowlAction.WIDE;
                        ballRun = 1;
                        break;
                    case 6:
                        matchBowlAction = MatchBowlAction.RUNNING_BETWEEN_THE_WICKETS;
                        System.out.println("Run taken:");
                        ballRun = sc.nextInt();
                        ball++;
                        over++;
                        break;
                    default:
                        break;
                }
                matchSummaryService.saveMatchSummary(new MatchSummary(id,
                        ballRun, over, matchBowlAction, batsMenId, bowlerId, matchId));
                teamScore = teamScore + ballRun;
                id++;
            }
            if (over % 1 == 0.5) {
                over = Double.valueOf(over.intValue() + 1);
            }
            teamOver = over;
        }
    }
}
