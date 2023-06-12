/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.service.tournament;

import cricscorer.Model.Tournament;

/**
 *
 * @author prabin
 */
public interface TournamentService {
    Boolean saveTournament(Tournament tournament);
    Tournament getAllTournament();
    Tournament getTournamentById(Integer id);
}
