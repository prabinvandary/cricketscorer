/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.service.player;

import cricscorer.Model.Player;

/**
 *
 * @author prabin
 */
public interface PlayerService {

    Boolean savePlayer(Player player);

    Player getAllPlayerDetais();

    Player getPlayerById(Integer id);

}
