/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.matchsummary;

import cricscorer.Model.MatchSummary;
import java.util.List;

/**
 *
 * @author prabin
 */
public interface MatchSummaryService {

    Boolean saveMatchSummary(MatchSummary matchSummary);

    List<MatchSummary> getAllMatchSummary();

    MatchSummary matchSummaryById(Integer id);
}
