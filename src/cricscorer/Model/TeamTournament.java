/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

/**
 *
 * @author prabin
 */
public class TeamTournament {

    private Integer id;
    private Integer teamId;
    private Integer tournamentId;

    public TeamTournament(Integer id, Integer teamId, Integer tournamentId) {
        this.id = id;
        this.teamId = teamId;
        this.tournamentId = tournamentId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

}
