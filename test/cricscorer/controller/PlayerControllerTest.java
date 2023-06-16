package cricscorer.controller;

import cricscorer.Model.Player;
import cricscorer.controller.dashboard.DashboardController;
import cricscorer.service.player.PlayerService;
import cricscorer.service.player.PlayerServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prabin
 */
public class PlayerControllerTest {

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
        DashboardController dashboardController = new DashboardController();
        PlayerService playerService = new PlayerServiceImpl();
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
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        instance.getBatsMenStatistics(dashboardController);

    }

    /**
     * Test of getStatisicsById method, of class PlayerController.
     */
    @Test
    public void testGetStatisicsById() {
        System.out.println("getStatisicsById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        instance.getStatisicsById(dashboardController);
    }

    /**
     * Test of savePlayer method, of class PlayerController.
     */
    @Test
    public void testSavePlayer() {
        System.out.println("savePlayer");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        instance.savePlayer(dashboardController);
    }

    /**
     * Test of getPlayerById method, of class PlayerController.
     */
    @Test
    public void testGetPlayerById() {
        System.out.println("getPlayerById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Player expResult = null;
        Player result = instance.getPlayerById(dashboardController);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllPlayer method, of class PlayerController.
     */
    @Test
    public void testGetAllPlayer() {
        System.out.println("getAllPlayer");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Boolean expResult = null;
        Boolean result = instance.getAllPlayer(dashboardController);
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePlayerById method, of class PlayerController.
     */
    @Test
    public void testDeletePlayerById() {
        System.out.println("deletePlayerById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Boolean expResult = null;
        Boolean result = instance.deletePlayerById(dashboardController);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePlayerById method, of class PlayerController.
     */
    @Test
    public void testUpdatePlayerById() {
        System.out.println("updatePlayerById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Boolean expResult = null;
        Boolean result = instance.updatePlayerById(dashboardController);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteById method, of class PlayerController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Boolean expResult = null;
        Boolean result = instance.deleteById(dashboardController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllList method, of class PlayerController.
     */
    @Test
    public void testGetAllList() {
        System.out.println("getAllList");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Boolean expResult = null;
        Boolean result = instance.getAllList(dashboardController);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class PlayerController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Player expResult = null;
        Player result = instance.getById(dashboardController);
        assertEquals(expResult, result);

    }

    /**
     * Test of updatePlayerByIdInLocalRepository method, of class
     * PlayerController.
     */
    @Test
    public void testUpdatePlayerByIdInLocalRepository() {
        System.out.println("updatePlayerByIdInLocalRepository");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Player expResult = null;
        Player result = instance.updatePlayerByIdInLocalRepository(dashboardController);
        assertEquals(expResult, result);

    }

    /**
     * Test of getByIdF method, of class PlayerController.
     */
    @Test
    public void testGetByIdF() {
        System.out.println("getByIdF");
        DashboardController dashboardController = null;
        PlayerController instance = new PlayerController();
        Player expResult = null;
        Player result = instance.getByIdF(dashboardController);
        assertEquals(expResult, result);

    }

}
