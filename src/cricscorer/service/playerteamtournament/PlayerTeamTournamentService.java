/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.playerteamtournament;

import cricscorer.Model.PlayerTeamTournament;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface PlayerTeamTournamentService {

    Boolean savePlayerTeamTournament(PlayerTeamTournament playerTeamTournament);

    List<PlayerTeamTournament> getAllPlayerTeamTournament();

    PlayerTeamTournament getPlayerTeamTournamentById(Integer id);

}
