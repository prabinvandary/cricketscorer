/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.pojo;

/**
 *
 * @author prabin
 */
public class TeamScoreDetailPojo {

    Integer teamId;
    Integer teamScore;
    Boolean isWinner;

    public TeamScoreDetailPojo(Integer teamId, Integer teamScore, Boolean isWinner) {
        this.teamId = teamId;
        this.teamScore = teamScore;
        this.isWinner = isWinner;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }
    

    public TeamScoreDetailPojo(Integer teamId, Integer teamScore) {
        this.teamId = teamId;
        this.teamScore = teamScore;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public Integer getTeamScore() {
        return teamScore;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public void setTeamScore(Integer teamScore) {
        this.teamScore = teamScore;
    }

}
