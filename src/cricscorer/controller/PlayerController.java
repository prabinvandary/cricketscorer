/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.controller;

import cricscorer.Model.MatchSummary;
import cricscorer.Model.Player;
import cricscorer.Model.TeamMatchScore;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import cricscorer.service.matchsummary.MatchSummaryService;
import cricscorer.service.matchsummary.MatchSummaryServiceImpl;
import cricscorer.service.player.PlayerService;
import cricscorer.service.player.PlayerServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author prabin
 */
public class PlayerController {

    Scanner sc = new Scanner(System.in);

    private final MatchSummaryService summaryService;

    private final PlayerService playerService = new PlayerServiceImpl();

    public PlayerController() {
        this.summaryService = new MatchSummaryServiceImpl();
    }

    void getBowlerStatistics(DashboardController dashboardController) throws NoSuchFieldException {
        System.out.println("Enter bowler id:");
        Integer id = sc.nextInt();
        List<MatchSummary> matchSummaryList
                = summaryService.getAllMatchSummaryByBowlerId(dashboardController.getMatchSummaryRepository(), id);
        System.out.println("Id\t\tMatch Id \t\tBowler Id\t\tRun\t\tOver\t\tAction");
        for (MatchSummary matchSummary : matchSummaryList) {
            System.out.println(matchSummary.getId() + "\t\t\t" + matchSummary.getMatchId()
                    + "\t\t\t" + matchSummary.getBowlerId() + "\t\t\t" + matchSummary.getRun()
                    + "\t\t\t" + matchSummary.getOver() + "\t\t\t" + matchSummary.getAction()
            );
        }
    }

    void getBatsMenStatistics(DashboardController dashboardController) throws NoSuchFieldException {
        System.out.println("Enter batsmen id:");
        Integer id = sc.nextInt();
        List<MatchSummary> matchSummaryList = summaryService.getAllMatchSummaryByBatsmenId(
                dashboardController.getMatchSummaryRepository(), id);
        System.out.println("Id\t\tMatch Id \t\tBatsmen Id\t\tRun\t\tOver\t\tAction");
        for (MatchSummary matchSummary : matchSummaryList) {
            System.out.println(matchSummary.getId() + "\t\t\t" + matchSummary.getMatchId()
                    + "\t\t\t" + matchSummary.getBatsMenId() + "\t\t\t" + matchSummary.getRun() + "\t\t\t"
                    + matchSummary.getOver() + "\t\t\t" + matchSummary.getAction()
            );
        }
    }

    void getStatisicsById(DashboardController dashboardController) {
        System.out.println("Enter id:");
        Integer id = sc.nextInt();
        List<MatchSummary> matchSummaryList = summaryService.getAllMatchSummaryById(dashboardController.getMatchSummaryRepository(), id);
        System.out.println("Id\t\tMatch Id \t\tBatsmen Id\t\tRun\t\tOver\t\tAction");
        for (MatchSummary matchSummary : matchSummaryList) {
            System.out.println(matchSummary.getId() + "\t\t\t" + matchSummary.getMatchId()
                    + "\t\t\t" + matchSummary.getBatsMenId() + "\t\t\t" + matchSummary.getRun() + "\t\t\t"
                    + matchSummary.getOver() + "\t\t\t" + matchSummary.getAction()
            );
        }
    }

//    void retunscpre(Integer id) {
//        List<MatchSummary> matchSummaryByPlayerId = new ArrayList<>();
//        for (MatchSummary scoreListByPlayerId : matchSummaryByPlayerId) {
//            if (Objects.equals(scoreListByPlayerId.getBatsMenId(), id)) {
//                matchSummaryByPlayerId.add(scoreListByPlayerId);
//            }
//        }
//
//    }
    public void savePlayer(DashboardController dashboardController) {
        System.out.println("Enter player details");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Enter respective number for player role:\n 1. BATSMEN\t 2. BOWLER\t 3.ALL ROUNDER");
        Integer role = sc.nextInt();
        PlayerRole playerRole = (role == 1) ? PlayerRole.BATSMEN : (role == 2)
                ? PlayerRole.BOWLER : (role == 3) ? PlayerRole.ALL_ROUNDER : null;
        System.out.println("Address");
        String address = sc.nextLine();
        playerService.savePlayer(dashboardController, new Player(null, name, playerRole, address));
    }

    public Player getPlayerById(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        Player player = playerService.getPlayerById(dashboardController, id);
        returnTableHeading();
        System.out.println(player.getId() + "\t\t" + player.getName()
                + "\t\t" + player.getAddress() + "\t\t" + player.getRole());

        return player;
    }

    public Boolean getAllPlayer(DashboardController dashboardController) {
        returnTableHeading();
        List<Player> playerList = playerService.getAllPlayerDetais(dashboardController);
        for (Player player : playerList) {
            System.out.println(player.getId() + "\t\t" + player.getName()
                    + "\t\t" + player.getAddress() + "\t\t" + player.getRole());
            System.out.println("\n");
        }
        return true;
    }

    public Boolean deletePlayerById(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        return playerService.deletePlayerById(dashboardController, id);
    }

    public Boolean updatePlayerById(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        Player player = getPlayerById(dashboardController);
        System.out.println("Enter new details:");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Enter respective number for player role:\n 1. BATSMEN\t 2. BOWLER\t 3.ALL ROUNDER");
        Integer role = sc.nextInt();
        PlayerRole playerRole = (role == 1) ? PlayerRole.BATSMEN : (role == 2)
                ? PlayerRole.BOWLER : (role == 3) ? PlayerRole.ALL_ROUNDER : null;
        System.out.println("Address");
        String address = sc.nextLine();
        player.setId(player.getId());
        player.setName((name == null || name.isBlank() || name.isEmpty()) ? player.getName() : name);
        player.setAddress((address == null || address.isEmpty() || address.isBlank() ? player.getAddress() : address));
        player.setRole(role == null? player.getRole() : playerRole);
        return playerService.deletePlayerById(dashboardController, id);
    }

    private void returnTableHeading() {
        System.out.println("Id\t\tName\t\tAddress\t\tPlayer Role");
    }
}
