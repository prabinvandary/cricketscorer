/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.MatchBowlAction;

/**
 *
 * @author prabin
 */
public class MatchSummary {

    private Integer id;
    private Integer run;
    private Double over;
    private MatchBowlAction action;
    public Integer batsMenId;
    public Integer bowlerId;
    private Integer matchId;

    public MatchSummary(Integer id, Integer run, Double over, MatchBowlAction action, Integer batsMenId, Integer bowlerId, Integer matchId) {
        this.id = id;
        this.run = run;
        this.over = over;
        this.action = action;
        this.batsMenId = batsMenId;
        this.bowlerId = bowlerId;
        this.matchId = matchId;
    }

    public MatchBowlAction getAction() {
        return action;
    }

    public Integer getBatsMenId() {
        return batsMenId;
    }

    public Integer getBowlerId() {
        return bowlerId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public Integer getRun() {
        return run;
    }

    public Double getOver() {
        return over;
    }

    public void setAction(MatchBowlAction action) {
        this.action = action;
    }

    public void setBatsMenId(Integer batsMenId) {
        this.batsMenId = batsMenId;
    }

    public void setBowlerId(Integer bowlerId) {
        this.bowlerId = bowlerId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public void setOver(Double over) {
        this.over = over;
    }

    public void setRun(Integer run) {
        this.run = run;
    }
}
