/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.controller;

import cricscorer.Model.TeamMatchScore;
import cricscorer.Util.GenerateId;
import cricscorer.enumvalues.TossAction;
import cricscorer.pojo.TeamScoreDetailPojo;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import cricscorer.service.teamMatchScoreService.TeamMatchScoreService;
import cricscorer.service.teamMatchScoreService.TeamMatchScoreServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreController {

    Integer firstTeamId, secondTeamId, tossWonTeamId;
    TossAction tossAction;
    private final TeamMatchScoreService teamMatchService;
    Integer firstBattingTeamId, secondBattingTeamId;
    List<Integer> teamIds = new ArrayList<>();

    public TeamMatchScoreController(TeamMatchScoreService teamMatchService) {
        this.teamMatchService = teamMatchService;
    }

    public TeamMatchScoreController() {
        this.teamMatchService = new TeamMatchScoreServiceImpl();
    }

    GenerateId generateId = new GenerateId();
    Scanner sc = new Scanner(System.in);

    public List<Integer> saveTeamMatchScore(TeamMatchScoreRepository teamMatchScoreRepository, Integer matchId) {

        returnMatchScoreDashboard();
        saveTeamMatchDetails(teamMatchScoreRepository, matchId,
                firstTeamId, Objects.equals(firstTeamId, tossWonTeamId) ? tossAction : null);
        saveTeamMatchDetails(teamMatchScoreRepository, matchId,
                secondTeamId, Objects.equals(secondTeamId, tossWonTeamId) ? tossAction : null);
        setBattingTeamOrder();
        return teamIds;
    }

    private void returnMatchScoreDashboard() {
        System.out.println("\n Enter first teams's id:");
        firstTeamId = sc.nextInt();
        System.out.println("\nEter second team's id");
        secondTeamId = sc.nextInt();
        tossWonTeamId = randomTossWinner();
        Integer tossActionRandom = randomTossWinner();
        tossAction = TossAction.valueOf((tossActionRandom == 1 ? "WON_AND_BAT_FIRST" : "WON_AND_BOWL_FIRST"));
        System.out.println("Team " + tossWonTeamId + " won the toss and choose " + tossAction.toString());
    }

    private void saveTeamMatchDetails(TeamMatchScoreRepository matchSummaryRepository,
            Integer matchId, Integer teamId, TossAction action) {
        teamMatchService.saveTeamMatchScore(matchSummaryRepository,
                new TeamMatchScore(generateId.returnId(), teamId, null, matchId,
                        null, action));
    }

    Integer randomTossWinner() {
        Random randomValue = new Random();
        Integer random = randomValue.nextInt(2) + 1;
        return random;
    }

    private void setBattingTeamOrder() {
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
        teamIds.add(firstBattingTeamId);
        teamIds.add(secondBattingTeamId);
    }

    public void updateTeamMatchScore(List<TeamScoreDetailPojo> teamScoreDetailPojo, TeamMatchScoreRepository teamMatchScoreRepository, Integer matchId) {
        teamMatchService.updateTeamMatchScore(teamScoreDetailPojo, teamMatchScoreRepository, matchId);
    }

    public Boolean getAllTeamMatchScoreDetails(TeamMatchScoreRepository teamMatchScoreRepository) {
        List<TeamMatchScore> allTeamMatchScores = teamMatchService.getAllTeamMatchScore(teamMatchScoreRepository);
        for (TeamMatchScore teamMatchScore : allTeamMatchScores) {
            System.out.println("Id: " + teamMatchScore.getId());
            System.out.println("Score: " + teamMatchScore.getScore());
            System.out.println("Is winner: " + teamMatchScore.getIsWinner());
            System.out.println("Match Id: " + teamMatchScore.getMatchId());
            System.out.println("Toss: " + teamMatchScore.getTossAction());
            System.out.println("Team id: " + teamMatchScore.getTeamId());

        }
        return true;
    }
}
