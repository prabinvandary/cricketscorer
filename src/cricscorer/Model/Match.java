package cricscorer.Model;

import cricscorer.repository.generic.GenericInterface;

public class Match implements GenericInterface{

    private Integer id;
    private String matchDate;
    private String venue;

    public Match(Integer id, String matchDate, String venue) {
        this.id = id;
        this.matchDate = matchDate;
        this.venue = venue;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}
