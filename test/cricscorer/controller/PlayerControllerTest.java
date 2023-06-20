package cricscorer.controller;

import cricscorer.Model.Player;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.enumvalues.PlayerRole;
import cricscorer.service.player.PlayerService;
import cricscorer.service.player.PlayerServiceImpl;
import java.text.spi.DateFormatProvider;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author prabin
 */
public class PlayerControllerTest {

    DashboardController dashboardController;
    PlayerService playerService;
    PlayerController playerController;

    public PlayerControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dashboardController = new DashboardController();
        playerService = new PlayerServiceImpl();
        playerController = new PlayerController();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBowlerStatistics method, of class PlayerController.
     */
    @Test
    public void testGetBowlerStatistics() throws Exception {
        System.out.println("getBowlerStatistics");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        instance.getBowlerStatistics(dashboardController);
    }

    /**
     * Test of getBatsMenStatistics method, of class PlayerController.
     */
    @Test
    public void testGetBatsMenStatistics() throws Exception {
        System.out.println("getBatsMenStatistics");

    }

    /**
     * Test of getStatisicsById method, of class PlayerController.
     */
    @Test
    public void testGetStatisicsById() {
        System.out.println("getStatisicsById");

    }

    /**
     * Test of savePlayer method, of class PlayerController.
     */
    @Test
    public void testSavePlayer() {
        System.out.println("Test Save Player:");
        List<Player> players = new ArrayList<>();

        Player player1 = new Player(1, "Prabin Bhandari", PlayerRole.ALL_ROUNDER, "Harion-Sarlahi.");
        Player player2 = new Player(2, "Pranish Adhikari", PlayerRole.BATSMEN, "Lalbandi-Sarlahi.");
        Player player3 = new Player(3, "Aayansh Adhikari", PlayerRole.BOWLER, "Lalbandi-Sarlahi.");
        Player player4 = new Player(4, "Dipti Ghimire", PlayerRole.ALL_ROUNDER, "Majorgung-Sarlahi.");
        Player player5 = new Player(5, "Divyansha Ghimire", PlayerRole.BATSMEN, "Harion-Sarlahi.");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        Boolean expResult = Boolean.TRUE;
        Boolean obtResult = playerService.savePlayer(dashboardController, player1);
        assertEquals(expResult, obtResult);
    }

    /**
     * Test of getPlayerById method, of class PlayerController.
     */
    @Test
    public void testGetPlayerById() {
        System.out.println("getPlayerById");
    }

    /**
     * Test of getAllPlayer method, of class PlayerController.
     */
    @Test
    public void testGetAllPlayer() {
        System.out.println("getAllPlayer");

    }

    /**
     * Test of deletePlayerById method, of class PlayerController.
     */
    @Test
    public void testDeletePlayerById() {
        System.out.println("deletePlayerById");

    }

    /**
     * Test of updatePlayerById method, of class PlayerController.
     */
    @Test
    public void testUpdatePlayerById() {
        System.out.println("updatePlayerById");

    }

    /**
     * Test of deleteById method, of class PlayerController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");

    }

    /**
     * Test of getAllList method, of class PlayerController.
     */
    @Test
    public void testGetAllList() {
        System.out.println("getAllList");

    }

    /**
     * Test of getById method, of class PlayerController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");

    }

    /**
     * Test of updatePlayerByIdInLocalRepository method, of class
     * PlayerController.
     */
    @Test
    public void testUpdatePlayerByIdInLocalRepository() {
        System.out.println("updatePlayerByIdInLocalRepository");

    }

    /**
     * Test of getByIdF method, of class PlayerController.
     */
    @Test
    public void testGetByIdF() {
        System.out.println("getByIdF");

    }

}
