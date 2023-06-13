package cricscorer.service.Match;

import cricscorer.Model.Match;
import cricscorer.repository.match.MatchRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prabin
 */
public class MatchServiceImpl implements MatchService {

    MatchRepository matchRepository = new MatchRepository();

    List<Match> matchList = new ArrayList<>();

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public Integer saveMatch(MatchRepository matchRepository, Match match) {
        return matchRepository.saveData(match).getId();
    }

    @Override
    public List<Match> getAllMatchDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Match getMatchDetailById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean saveMatchDetails(Match match) {
        matchRepository.saveData(match);
        return null;
    }

}
