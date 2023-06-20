/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.repository.generic.GenericAbstractClass;
import cricscorer.repository.generic.GenericInterface;

/**
 *
 * @author prabin
 */
public class TeamTournament extends GenericAbstractClass implements GenericInterface {

    private Integer teamId;
    private Integer tournamentId;

    public TeamTournament(Integer id, Integer teamId, Integer tournamentId) {
        this.setId(id);
        this.teamId = teamId;
        this.tournamentId = tournamentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public String getTableName() {
        return "team_tournament";
    }

}
