/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.teamMatchScoreService;

import cricscorer.Model.TeamMatchScore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreServiceImpl implements TeamMatchScoreService {

    List<TeamMatchScore> teamMatch = new ArrayList<>();

    @Override
    public Boolean saveTeamMatchScore(TeamMatchScore teamMatchScore) {
        teamMatch.add(teamMatchScore);
        return true;
    }

    @Override
    public List<TeamMatchScore> getAllTeamMatchScore() {
        return teamMatch;
    }

    @Override
    public TeamMatchScore getTeamMatchScoreById(Integer id) {
        return teamMatch.get(id);
    }
}
