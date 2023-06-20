package cricscorer.Model;

import cricscorer.repository.generic.GenericAbstractClass;
import cricscorer.repository.generic.GenericInterface;

public class Match extends GenericAbstractClass implements GenericInterface{

    private String matchDate;
    private String venue;

    public Match(Integer id, String matchDate, String venue) {
        this.setId(id);
        this.matchDate = matchDate;
        this.venue = venue;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getVenue() {
        return venue;
    }
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Override
    public String getTableName() {
        return "match";
    }

}
