/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.playerteamtournament;

import cricscorer.Model.PlayerTeamTournament;
import cricscorer.repository.generic.genericrepository.GenericRepository;

/**
 *
 * @author prabin
 */
public class PlayerTeamTournamentRepository extends GenericRepository<PlayerTeamTournament, Integer> {

    @Override
    public Integer getId(PlayerTeamTournament item) {
        return item.getId();
    }

}
