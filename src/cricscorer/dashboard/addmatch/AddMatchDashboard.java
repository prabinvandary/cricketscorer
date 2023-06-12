package cricscorer.dashboard.addmatch;

import cricscorer.Model.Match;
import cricscorer.Model.MatchSummary;
import cricscorer.Model.TeamMatchScore;
import cricscorer.enumvalues.MatchBowlAction;
import cricscorer.enumvalues.TossAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class AddMatchDashboard {

    List<Match> matchList = new ArrayList<>();

    List<TeamMatchScore> teamMatch = new ArrayList<>();

    List<MatchSummary> matchSummarys = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    Integer teamScore = 0;

    Integer firstBattingTeamRun = 0;

    Integer secondBattingTeamRun = 0;

    Integer firstTeamId, secondTeamId, tossWonTeamId;
    TossAction tossAction;

    public void returnAddMatchDashboard() {
        System.out.println("Welcome to the add match dashboard.");
        System.out.println("\n Let's start the match.");
        Integer matchId = saveMatch();
        saveTeamMatchScore(matchId);
    }

    private Integer saveMatch() {
        System.out.println("\n Enter match date in format of yyyy-mm-dd:");
        String matchDate = sc.next();
        System.out.println("\n Enter match venue:");
        String matchVenue = sc.next();
        matchList.add(new Match(1, matchDate, matchVenue));
        return 1;
    }

    private void saveTeamMatchScore(Integer matchId) {
        System.out.println("\n Enter first teams's id:");
        firstTeamId = sc.nextInt();
        System.out.println("\nEter second team's id");
        secondTeamId = sc.nextInt();
        tossWonTeamId = randomTossWinner();
        Integer tossActionRandom = randomTossWinner();
        tossAction = TossAction.valueOf((tossActionRandom == 1 ? "WON_AND_BAT_FIRST" : "WON_AND_BOWL_FIRST"));

        System.out.println("Team " + tossWonTeamId + " won the toss and choose " + tossAction.toString());
        System.out.println("What action did the toss won team choosen?");
        System.out.println("Enter 1. for:WON_AND_BAT_FIRST\n 2. for:WON_AND_BOWL_FIRST");
        tossAction = TossAction.valueOf((sc.nextInt() == 1 ? "WON_AND_BAT_FIRST" : "WON_AND_BOWL_FIRST"));
        saveTeamMatchScore(new TeamMatchScore(1, firstTeamId, null, matchId,
                null, Objects.equals(firstTeamId, tossWonTeamId) ? tossAction : null));
        saveTeamMatchScore(new TeamMatchScore(2, secondTeamId, null, matchId,
                null, Objects.equals(secondTeamId, tossWonTeamId) ? tossAction : null));
        Integer firstBattingTeamId = null;
        Integer secondBattingTeamId = null;

        if (Objects.equals(firstTeamId, tossWonTeamId) && Objects.equals(
                tossAction, TossAction.WON_AND_BAT_FIRST)) {
            firstBattingTeamId = firstTeamId;
            secondBattingTeamId = secondTeamId;
        } else if (Objects.equals(secondTeamId, tossWonTeamId)
                && Objects.equals(tossAction, TossAction.WON_AND_BAT_FIRST)) {
            firstBattingTeamId = secondTeamId;
            secondBattingTeamId = firstTeamId;

        } else if (Objects.equals(firstTeamId, tossWonTeamId)
                && Objects.equals(tossAction, TossAction.WON_AND_BOWL_FIRST)) {
            firstBattingTeamId = secondTeamId;
            secondBattingTeamId = firstTeamId;

        } else if (Objects.equals(secondTeamId, tossWonTeamId)
                && Objects.equals(tossAction, TossAction.WON_AND_BOWL_FIRST)) {
            firstBattingTeamId = firstTeamId;
            secondBattingTeamId = secondTeamId;

        }

        addMatchSummaryDashboard(matchId);
        System.out.println("Here is the summary of first inning:");
        viewMatchSummaryDashboard();
        firstBattingTeamRun = teamScore;
        System.out.println("\n");
        System.out.println("Let's start another inning of team:");
        teamScore = 0;
        addMatchSummaryDashboard(matchId);
        System.out.println("\n");
        System.out.println("Here is the summary of second inning:");

        System.out.println("\n");
        viewMatchSummaryDashboard();
        secondBattingTeamRun = teamScore;

        updateTeamMatchScore(firstBattingTeamId, matchId,
                firstBattingTeamRun, (firstBattingTeamRun > secondBattingTeamRun));
        updateTeamMatchScore(secondBattingTeamId, matchId,
                secondBattingTeamRun, (secondBattingTeamRun > firstBattingTeamRun));
        viewTeamMatchScore();

    }

    void saveTeamMatchScore(TeamMatchScore teamMatchScore) {
        teamMatch.add(teamMatchScore);
    }

    public void addMatchSummaryDashboard(Integer matchId) {
        System.out.println("Let's start the match and enter the each balls details:\n Are you ready??");
        Double over = 0.0;
        Integer ball = 0;
        Integer wicket = 0;

        MatchBowlAction matchBowlAction = null;

        while (over < 1.0) {
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
                String decimalPart = String.format("%.1f", (over - over.intValue()));
                if (decimalPart.endsWith("0.6")) {
                    over = Math.floor(over) + 1;
                }
                matchSummarys.add(new MatchSummary(id,
                        ballRun, over, matchBowlAction, batsMenId, bowlerId, matchId));
                teamScore = teamScore + ballRun;
                id++;
                if (wicket == 10) {
                    return;
                }
            }
            if (wicket == 10) {
                return;
            }
            ball = 0;
            System.out.println("Here's the update after " + over + ":\n");
            System.out.println("Over:" + over);
            System.out.println("Run:" + teamScore);
            System.out.println("Run Rate:" + calculateRunRate(teamScore, over));
        }
    }

    private void viewMatchSummaryDashboard() {
        System.out.println("Here is the summary of first inning:");

        System.out.println("Id\tMatch Id\tBowl Action\tBats Men Id"
                + "\tBowler Id\tRun\tOver");
        for (MatchSummary summary : matchSummarys) {
            System.out.print(summary.getId() + "\t");
            System.out.print(summary.getMatchId() + "\t\t");
            System.out.print(summary.getAction() + "\t\t");
            System.out.print(summary.getBatsMenId() + "\t\t");
            System.out.print(summary.getBowlerId() + "\t\t");
            System.out.print(summary.getRun() + "\t");
            System.out.print(summary.getOver() + "\t");
            System.out.print("\n");
        }

    }

    private String calculateRunRate(Integer teamScore, Double over) {
        Double runrate = teamScore / over;
        return String.format("%.2f", runrate);
    }

    void updateTeamMatchScore(Integer teamId, Integer matchId, Integer score, Boolean isWinner) {
        for (TeamMatchScore match : teamMatch) {
            if (Objects.equals(match.getMatchId(), matchId)
                    && Objects.equals(match.getTeamId(), teamId)) {
                match.setScore(score);
                match.setIsWinner(isWinner);
            }
        }
    }

    private void viewTeamMatchScore() {
        System.out.println("Id\tMatch Id\tIs winner\tScore"
                + "\t\tToss Action\t\tTeam Id");
        for (TeamMatchScore matchScore : teamMatch) {
            System.out.print(matchScore.getId() + "\t");
            System.out.print(matchScore.getMatchId() + "\t\t");
            System.out.print(matchScore.getIsWinner() + "\t\t");
            System.out.print(matchScore.getScore() + "\t\t");
            System.out.print(matchScore.getTossAction() != null
                    ? matchScore.getTossAction() + "\t" : matchScore.getTossAction() + "\t\t\t");
            System.out.print(matchScore.getTeamId() + "\t");
            System.out.print("\n");
        }
    }

    Integer randomTossWinner() {
        Random randomValue = new Random();
        Integer random = randomValue.nextInt(2) + 1;
        return random;
    }
}
