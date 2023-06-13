/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.Match;

import cricscorer.Model.Match;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface MatchService {

    Integer saveMatch(Match match);

    List<Match> getAllMatchDetails();

    Match getMatchDetailById(Integer id);

    Boolean saveMatchDetails(Match match);

}
