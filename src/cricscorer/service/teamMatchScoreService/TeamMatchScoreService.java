/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.teamMatchScoreService;

import cricscorer.Model.TeamMatchScore;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface TeamMatchScoreService {
    Boolean saveTeamMatchScore(TeamMatchScore teamMatchScore);
    
    List<TeamMatchScore> getAllTeamMatchScore();
    
    TeamMatchScore getTeamMatchScoreById(Integer id);
}
