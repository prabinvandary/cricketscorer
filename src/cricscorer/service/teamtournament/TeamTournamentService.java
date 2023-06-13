/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.teamtournament;

import cricscorer.Model.TeamTournament;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface TeamTournamentService {

    Boolean saveTeamTournament(TeamTournament teamTournament);

    List<TeamTournament> getAllTeamTournament();

    TeamTournament getTeamTournamentById(Integer id);
}
