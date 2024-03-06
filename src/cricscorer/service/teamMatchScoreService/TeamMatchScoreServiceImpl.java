/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.teamMatchScoreService;

import cricscorer.Model.TeamMatchScore;
import cricscorer.pojo.TeamScoreDetailPojo;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreServiceImpl implements TeamMatchScoreService {

    @Override
    public Boolean saveTeamMatchScore(TeamMatchScoreRepository matchSummaryRepository, TeamMatchScore teamMatchScore) {
        matchSummaryRepository.saveData(teamMatchScore);
        return true;
    }

    @Override
    public void updateTeamMatchScore(List<TeamScoreDetailPojo> teamScoreDetailPojo,
            TeamMatchScoreRepository teamMatchScoreRepository, Integer matchId) {
        updateIsWinner(teamScoreDetailPojo);
        List<TeamMatchScore> allTeamMatchScore = teamMatchScoreRepository.getAllData();
        for (TeamScoreDetailPojo teamScoreDetailPojo1 : teamScoreDetailPojo) {
            for (TeamMatchScore match : allTeamMatchScore) {
                if (Objects.equals(match.getMatchId(), matchId)
                        && Objects.equals(match.getTeamId(), teamScoreDetailPojo1.getTeamId())) {
                    match.setScore(teamScoreDetailPojo1.getTeamScore());
                    match.setIsWinner(teamScoreDetailPojo1.getIsWinner());
                }
            }
        }
    }
    // Find the highest score

    private Boolean updateIsWinner(List<TeamScoreDetailPojo> teamScoreDetailPojos) {
        Integer highestScore = Integer.MIN_VALUE;

        for (TeamScoreDetailPojo scoreDetailPojo : teamScoreDetailPojos) {
            if (scoreDetailPojo.getTeamScore() > highestScore) {
                highestScore = scoreDetailPojo.getTeamScore();
            }
        }

        // Set the isWinner flag based on the highest score
        for (TeamScoreDetailPojo scoreDetailPojo : teamScoreDetailPojos) {
            if (Objects.equals(scoreDetailPojo.getTeamScore(), highestScore)) {
                scoreDetailPojo.setIsWinner(true);
            } else {
                scoreDetailPojo.setIsWinner(false);
            }
        }
        return true;
    }

    @Override
    public List<TeamMatchScore> getAllTeamMatchScore(TeamMatchScoreRepository teamMatchScoreRepository) {
        return teamMatchScoreRepository.getAllData();
    }
}
