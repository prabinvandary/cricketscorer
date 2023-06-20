/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.teammatchscore;

import cricscorer.Model.TeamMatchScore;
import cricscorer.repository.generic.genericrepository.GenericRepository;

/**
 *
 * @author prabin
 */
public class TeamMatchScoreRepository extends GenericRepository<TeamMatchScore, Integer> {

    @Override
    public Integer getId(TeamMatchScore item) {
        return item.getId();
    }

}
