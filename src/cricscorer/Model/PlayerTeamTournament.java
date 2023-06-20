/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.PlayerPosition;
import cricscorer.repository.generic.GenericAbstractClass;
import cricscorer.repository.generic.GenericInterface;

/**
 *
 * @author prabin
 */
public class PlayerTeamTournament extends GenericAbstractClass  implements GenericInterface{

    private Integer playerTeamTournamentId;
    private Integer playerId;
    private PlayerPosition position;
    private Boolean isWicketKeeper;

    public PlayerTeamTournament(Integer id, Integer playerTeamTournamentId, Integer playerId, PlayerPosition position, Boolean isWicketKeeper) {
        this.setId(id);
        this.playerTeamTournamentId = playerTeamTournamentId;
        this.playerId = playerId;
        this.position = position;
        this.isWicketKeeper = isWicketKeeper;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    
    public Boolean getIsWicketKeeper() {
        return isWicketKeeper;
    }

    public Integer getPlayerTeamTournamentId() {
        return playerTeamTournamentId;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setIsWicketKeeper(Boolean isWicketKeeper) {
        this.isWicketKeeper = isWicketKeeper;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public void setPlayerTeamTournamentId(Integer playerTeamTournamentId) {
        this.playerTeamTournamentId = playerTeamTournamentId;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    @Override
    public String getTableName() {
        return "player_team_tournament";
    }

}
