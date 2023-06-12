package cricscorer.view;

import cricscorer.controller.TeamController;

public class TeamView {

    TeamController teamController = new TeamController();

    public String showFromView() {
        return teamController.getTeamName();
    }
}
