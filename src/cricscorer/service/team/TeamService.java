/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.team;

import cricscorer.Model.Team;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface TeamService {

    Boolean saveTeam(Team team);

    List<Team> getAllTeams();

    Team getTeamById(Integer id);
}
