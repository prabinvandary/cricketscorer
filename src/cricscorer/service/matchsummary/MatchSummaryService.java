/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.matchsummary;

import cricscorer.Model.MatchSummary;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface MatchSummaryService {

    Boolean saveMatchSummary(MatchSummaryRepository matchSummaryRepository, MatchSummary matchSummary);

    List<MatchSummary> getAllMatchSummary(MatchSummaryRepository matchSummaryRepository);

    MatchSummary matchSummaryById(Integer id);

    List<MatchSummary> getAllMatchSummaryByBatsmenId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException;

    List<MatchSummary> getAllMatchSummaryByBowlerId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException;
    
    List<MatchSummary> getAllMatchSummaryById(MatchSummaryRepository matchSummaryRepository, Integer id);
}
