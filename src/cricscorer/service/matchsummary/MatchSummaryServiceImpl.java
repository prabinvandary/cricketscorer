/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.matchsummary;

import cricscorer.Model.MatchSummary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prabin
 */
public class MatchSummaryServiceImpl implements MatchSummaryService {
    List<MatchSummary> matchSummaryList=new ArrayList<>();

    public List<MatchSummary> getMatchSummaryList() {
        return matchSummaryList;
    }

    public void setMatchSummaryList(List<MatchSummary> matchSummaryList) {
        this.matchSummaryList = matchSummaryList;
    }
    
    

    @Override
    public Boolean saveMatchSummary(MatchSummary matchSummary) {
        matchSummaryList.add(matchSummary);
        return true;
    }

    @Override
    public List<MatchSummary> getAllMatchSummary() {
        return null;
    }

    @Override
    public MatchSummary matchSummaryById(Integer id) {
        return null;
    }

}
