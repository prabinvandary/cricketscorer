/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.matchsummary;

import cricscorer.Model.MatchSummary;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import java.sql.SQLException;
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
    public List<MatchSummary> getAllMatchSummary(MatchSummaryRepository matchSummaryRepository) {
        return matchSummaryRepository.getAllData();
    }

    @Override
    public MatchSummary matchSummaryById(Integer id) {
        return null;
    }

    /**
     *
     * @param matchSummaryRepository
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    @Override
    public List<MatchSummary> getAllMatchSummaryByBatsmenId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        return matchSummaryRepository.returnMatchSummaryByBatsmenId(matchSummaryRepository, id);
    }

    @Override
    public List<MatchSummary> getAllMatchSummaryByBowlerId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        return matchSummaryRepository.returnMatchSummaryByBowlerId(matchSummaryRepository, id);
    }

    @Override
    public List<MatchSummary> getAllMatchSummaryById(MatchSummaryRepository matchSummaryRepository, Integer id) {
        return matchSummaryRepository.getById(id);
    }

    @Override
    public Boolean insertDataToDatabase(MatchSummary matchSummary,MatchSummaryRepository matchSummaryRepository) throws SQLException {
        matchSummaryRepository.insertDataToDatabase(matchSummary);
        return true;
    }
}
