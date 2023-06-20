/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.controller;

import cricscorer.Model.MatchSummary;
import cricscorer.Model.Player;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import cricscorer.service.matchsummary.MatchSummaryService;
import cricscorer.service.matchsummary.MatchSummaryServiceImpl;
import cricscorer.service.player.PlayerService;
import cricscorer.service.player.PlayerServiceImpl;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author prabin
 */
public class PlayerController {

    private Pattern stringPattern;

    Scanner sc = new Scanner(System.in);

    private final MatchSummaryService summaryService;

    private final PlayerService playerService = new PlayerServiceImpl();

    public PlayerController() {
        this.summaryService = new MatchSummaryServiceImpl();
    }

    /**
     * Get Bowler statistics from match summary from database
     *
     * @param dashboardController
     * @throws NoSuchFieldException
     */
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

    public Boolean savePlayer(DashboardController dashboardController) {
        System.out.println("Enter player details");
        System.out.println("Name:");
        String name = sc.nextLine();

        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            System.out.println("Name is not valid enter again:");
            return false;
        }
        System.out.println("Enter respective number for player role:\n 1. BATSMEN\t 2. BOWLER\t 3.ALL ROUNDER");
        Integer role = sc.nextInt();
        PlayerRole playerRole = (role == 1) ? PlayerRole.BATSMEN : (role == 2)
                ? PlayerRole.BOWLER : (role == 3) ? PlayerRole.ALL_ROUNDER : null;
        System.out.println("Address");
        String address = sc.next();
        playerService.savePlayer(dashboardController, new Player(null, name, playerRole, address));
        return true;
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
        printPlayer(playerList);
        return true;
    }

    private void printPlayer(List<Player> playerList) {
        for (Player player : playerList) {
            System.out.println(player.getId() + "\t\t" + player.getName()
                    + "\t\t" + player.getAddress() + "\t\t" + player.getRole());
            System.out.println("\n");
        }
    }

    public Boolean deletePlayerById(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        return playerService.deletePlayerById(dashboardController, id);
    }

    public Boolean updatePlayerById(DashboardController dashboardController) {
        Player player = getPlayerById(dashboardController);
        player = askDetailsAndReturnPlayer(player);
        return playerService.updatePlayerById(dashboardController, player);
    }

    private Player askDetailsAndReturnPlayer(Player player) {
        System.out.println("Enter new details:");
        System.out.println("Name:");
        String playerName = sc.next();
        System.out.println("Enter respective number for player role:\n 1. BATSMEN\t 2. BOWLER\t 3.ALL ROUNDER");
        Integer roleInteger = sc.nextInt();
        PlayerRole playerRole = (roleInteger == 1) ? PlayerRole.BATSMEN : (roleInteger == 2)
                ? PlayerRole.BOWLER : (roleInteger == 3) ? PlayerRole.ALL_ROUNDER : null;
        System.out.println("Address");
        String addressString = sc.next();
        player.setId(player.getId());
        player.setName((playerName == null || playerName.isEmpty() || playerName.isEmpty()) ? player.getName() : playerName);
        player.setAddress((addressString == null || addressString.isEmpty() || addressString.isEmpty() ? player.getAddress() : addressString));
        player.setRole(roleInteger == null ? player.getRole() : playerRole);
        return player;
    }

    private void returnTableHeading() {
        System.out.println("Id\t\tName\t\tAddress\t\tPlayer Role");
    }

    public Boolean deleteById(DashboardController dashboardController) {
        System.out.println("Enter player id to delete:");
        Integer id = sc.nextInt();
        return playerService.deleteById(dashboardController, id);
    }

    public Boolean getAllList(DashboardController dashboardController) {
        returnTableHeading();
        List<Player> playerList = playerService.getAllFromList(dashboardController);
        printPlayer(playerList);
        return true;
    }

    public Player getById(DashboardController dashboardController) {
        System.out.println("Enter player id to view:");
        Integer id = sc.nextInt();
        List<Player> players = dashboardController.getPlayerRepository().getById(id);
        returnTableHeading();
        printPlayer(players);
        return players.get(0);
    }

    public Player updatePlayerByIdInLocalRepository(DashboardController dashboardController) {
        Player player = getById(dashboardController);
        player = askDetailsAndReturnPlayer(player);
        playerService.updatePlayerByIdLocalRepository(dashboardController, player);
        return null;
    }

    public Player getByIdF(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        Player player = playerService.getPlayerById(dashboardController, id);
        returnTableHeading();
        System.out.println(player.getId() + "\t\t" + player.getName()
                + "\t\t" + player.getAddress() + "\t\t" + player.getRole());
        return player;
    }

    public Boolean getPlayerByIdFromDatabase(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        Player player = playerService.getPlayerByIdFromDatabase(dashboardController, id);
        returnTableHeading();
        System.out.println(player.getId() + "\t\t" + player.getName()
                + "\t\t" + player.getAddress() + "\t\t" + player.getRole());

        return true;
    }

    public Boolean deletePlayerFromDatabase(DashboardController dashboardController) {
        System.out.println("Enter player id:");
        Integer id = sc.nextInt();
        System.out.println(dashboardController.getPlayerRepository().deleteByIdFromDatabase("player", id));
        return true;
    }

    public Boolean getAllPlayerFromDatabase(DashboardController dashboardController) {
        returnTableHeading();
        List<Player> playerList = playerService.getAllFromDatabase(dashboardController);
        printPlayer(playerList);
        return true;
    }
}
