/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.matchsummary;

import cricscorer.Model.MatchSummary;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prabin
 */
public class MatchSummaryServiceImpl implements MatchSummaryService {
    @Override
    public Boolean saveMatchSummary(MatchSummaryRepository matchSummaryRepository, MatchSummary matchSummary) {
        matchSummaryRepository.saveData(matchSummary);
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
