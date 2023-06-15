/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.TossAction;
import cricscorer.repository.generic.GenericInterface;

/**
 *
 * @author prabin
 */
public class TeamMatchScore implements GenericInterface{

    private Integer id;
    private Integer teamId;
    private Integer score;
    private Integer matchId;
    private Boolean isWinner;
    private TossAction tossAction;

    public TeamMatchScore(Integer id, Integer teamId, Integer score, Integer matchId, Boolean isWinner, TossAction tossAction) {
        this.id = id;
        this.teamId = teamId;
        this.score = score;
        this.matchId = matchId;
        this.isWinner = isWinner;
        this.tossAction = tossAction;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public TossAction getTossAction() {
        return tossAction;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setTossAction(TossAction tossAction) {
        this.tossAction = tossAction;
    }

}
