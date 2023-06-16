/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

import cricscorer.Model.Player;
import cricscorer.enumvalues.PlayerRole;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
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
public class GenericRepositoryTest {

    public GenericRepositoryTest() {
    }

    GenericRepository<Player, Integer> genericRepository;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        genericRepository = new GenericRepository<Player, Integer>() {
            @Override
            public Integer getId(Player item) {
                return item.getId();
            }
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveData method, of class GenericRepository.
     */
    @Test
    public void testSaveData() {
        System.out.println("Save Data");
        Player player = new Player(1, "Prabin Bhandari", PlayerRole.BATSMEN, "Harion Sarlahi");
        genericRepository.saveData(player);
        Player expResult = player;
        Player result = genericRepository.saveData(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class GenericRepository.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Integer id = 2;
        Player player = new Player(1, "Prabin Bhandari", PlayerRole.BATSMEN, "Harion Sarlahi");
        genericRepository.saveData(player);
        Player expPlayer = null;
        Player result = genericRepository.getById(id).stream().findFirst().orElse(null);
        assertEquals(expPlayer, result);
    }

    /**
     * Test of getAllData method, of class GenericRepository.
     */
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
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
        List<Player> expResult = players;
        genericRepository.saveAllData(players);
        List<Player> result = genericRepository.getAllData();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListByField method, of class GenericRepository.
     */
    @Test
    public void testGetListByField() {
        System.out.println("getListByField");
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
        genericRepository.saveAllData(players);

        try {
            Field field = Player.class.getDeclaredField("id");
            Integer value = 1;
            List<Player> expResult = new ArrayList<>();
            expResult.add(player1);
            List<Player> result = genericRepository.getListByField(field, value);
            assertEquals(expResult, result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Test of getById method, of class GenericRepository.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
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
        genericRepository.saveAllData(players);
        List<Player> expResult = new ArrayList<>();
        expResult.add(player1);
        List<Player> result = genericRepository.getById(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteById method, of class GenericRepository.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
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
        genericRepository.saveAllData(players);
        Boolean expResult = true;
        Boolean result = genericRepository.deleteById(10);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateById method, of class GenericRepository.
     */
    @Test
    public void testUpdateById() {
        System.out.println("updateById");
        List<Player> players = new ArrayList<>();

        Player player1 = new Player(1, "Prabin Bhandari",
                PlayerRole.ALL_ROUNDER, "Harion-Sarlahi.");
        Player player2 = new Player(2, "Pranish Adhikari",
                PlayerRole.BATSMEN, "Lalbandi-Sarlahi.");
        Player player3 = new Player(3, "Aayansh Adhikari",
                PlayerRole.BOWLER, "Lalbandi-Sarlahi.");
        Player player4 = new Player(4, "Dipti Ghimire",
                PlayerRole.ALL_ROUNDER, "Majorgung-Sarlahi.");
        Player player5 = new Player(5, "Divyansha Ghimire",
                PlayerRole.BATSMEN, "Harion-Sarlahi.");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        genericRepository.saveAllData(players);
        Boolean expResult = true;
        Boolean result = genericRepository.updateById(1, player1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class GenericRepository.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Player item = null;
        Integer expResult = null;
        Integer result = genericRepository.getId(item);
        assertEquals(expResult, result);
    }

}
