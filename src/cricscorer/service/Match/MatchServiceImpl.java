/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.Match;

import cricscorer.Model.Match;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prabin
 */
public class MatchServiceImpl implements MatchService {

    List<Match> matchList = new ArrayList<>();

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public Integer saveMatch(Match match) {
        List<Match> matches = new ArrayList<>();
        matches.add(match);
        return 1;
    }

    @Override
    public List<Match> getAllMatchDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Match getMatchDetailById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
