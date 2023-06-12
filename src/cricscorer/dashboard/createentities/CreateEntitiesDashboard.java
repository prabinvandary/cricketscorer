package cricscorer.dashboard.createentities;

import cricscorer.Model.Team;
import cricscorer.service.team.TeamService;
import java.util.Scanner;

public class CreateEntitiesDashboard {
            private final TeamService teamService;

    public CreateEntitiesDashboard(cricscorer.service.team.TeamService teamService) {
        this.teamService = teamService;
    }


    Scanner sc = new Scanner(System.in);

    public void returnCreateEntitiesDashboard() {
        System.out.println("Welcome to the entities creation dashboard.\n");
        System.out.println("1. For Team creation \n 2.For Tournament creation \n 3. For Player creation");
        Integer dashboarddInteger = sc.nextInt();
        switch (dashboarddInteger) {
            case 1:
                teamCreationDashboard();
                break;
            case 2:
                tournamentCreationDashboard();
                break;
            case 3:
                playerCreationDashboard();
                break;
            default:
                System.out.println("Invalid menu selected.");
                ;
        }
    }

    private void teamCreationDashboard() {
        System.out.println("Enter the following details for the creation of a new team:");
        System.out.println("Name:");
        String name = sc.next();
        System.out.println("Address");
        String address = sc.next();
        System.out.println("Manager");
        String manager = sc.next();
        Team team = new Team(null, name, address, manager);
        teamService.saveTeam(team);
    }

    private void tournamentCreationDashboard() {
    }

    private void playerCreationDashboard() {
    }
}
