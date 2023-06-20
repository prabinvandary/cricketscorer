/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.teamMatchScoreService;

import cricscorer.Model.TeamMatchScore;
import cricscorer.pojo.TeamScoreDetailPojo;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface TeamMatchScoreService {

    Boolean saveTeamMatchScore(TeamMatchScoreRepository matchSummaryRepository, TeamMatchScore teamMatchScore);


    public void updateTeamMatchScore(List<TeamScoreDetailPojo> teamScoreDetailPojo, TeamMatchScoreRepository teamMatchScoreRepository, Integer matchId);

    List<TeamMatchScore> getAllTeamMatchScore(TeamMatchScoreRepository teamMatchScoreRepository);

}
