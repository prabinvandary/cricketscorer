package cricscorer.repository.matchsummary;

import cricscorer.Model.MatchSummary;
import cricscorer.repository.generic.genericrepository.GenericRepository;
import java.lang.reflect.Field;
import java.util.List;

public class MatchSummaryRepository extends GenericRepository<MatchSummary, Integer> {

    public List<MatchSummary> returnMatchSummaryByBatsmenId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        Field field = MatchSummary.class.getDeclaredField("batsMenId");
        return matchSummaryRepository.getListByField(field, id);
    }
     public List<MatchSummary> returnMatchSummaryByBowlerId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        Field field = MatchSummary.class.getDeclaredField("bowlerId");
        return matchSummaryRepository.getListByField(field, id);
    }

    @Override
    public Integer getId(MatchSummary item) {
        return item.getId();
    }
}
