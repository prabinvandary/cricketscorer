package cricscorer.repository.match;

import cricscorer.Model.Match;
import cricscorer.repository.generic.genericrepository.GenericRepository;

public class MatchRepository extends GenericRepository<Match, Integer> {

    @Override
    public Integer getId(Match item) {
        return item.getId();
    }
    
    
}
