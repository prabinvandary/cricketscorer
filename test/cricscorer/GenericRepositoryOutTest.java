package cricscorer;

import cricscorer.Model.Player;
import cricscorer.repository.generic.GenericInterface;
import cricscorer.repository.generic.genericrepository.GenericRepository;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenericRepositoryOutTest {

    private GenericRepository<Player, Integer> repository;

    public GenericRepositoryOutTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        repository = new GenericRepository<Player, Integer>() {
           
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
        System.out.println("saveData");
        Player data = new Player(1, "Data 1");

        Player savedData = repository.saveData(data);

        assertNotNull(savedData);
        assertEquals(data, savedData);
        assertEquals(1, repository.getAllData().size());
        assertTrue(repository.getAllData().contains(data));
    }

    /**
     * Test of getData method, of class GenericRepository.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Player data = new Player(1, "Data 1");
        repository.saveData(data);

        Player retrievedData = repository.getData(0);

        assertNotNull(retrievedData);
        assertEquals(data, retrievedData);
    }

    /**
     * Test of getAllData method, of class GenericRepository.
     */
    @Test
    public void testGetAllData() {
        System.out.println("getAllData");
        Player data1 = new Player(1, "Data 1");
        Player data2 = new Player(2, "Data 2");
        repository.saveData(data1);
        repository.saveData(data2);

        List<Player> allData = repository.getAllData();

        assertNotNull(allData);
        assertEquals(2, allData.size());
        assertTrue(allData.contains(data1));
        assertTrue(allData.contains(data2));
    }

    /**
     * Test of getListByField method, of class GenericRepository.
     * @throws java.lang.NoSuchFieldException
     */
    @Test
    public void testGetListByField() throws NoSuchFieldException {
        System.out.println("getListByField");
        Player data1 = new Player(1, "Data 1");
        Player data2 = new Player(2, "Data 2");
        repository.saveData(data1);
        repository.saveData(data2);

        Field nameField = Player.class.getDeclaredField("name");

        List<Player> result = repository.getListByField(nameField, "Data 1");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(data1, result.get(0));
    }

    /**
     * Test of getById method, of class GenericRepository.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Player data1 = new Player(1, "Data 1");
        Player data2 = new Player(2, "Data 2");
        repository.saveData(data1);
        repository.saveData(data2);

        List<Player> result = repository.getById(2);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(data2, result.get(0));
    }

    /**
     * Test of deleteById method, of class GenericRepository.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        Player data1 = new Player(1, "Data 1");
        Player data2 = new Player(2, "Data 2");
        repository.saveData(data1);
        repository.saveData(data2);

        boolean deletionResult = repository.deleteById(1);

        assertTrue(deletionResult);
        assertEquals(1, repository.getAllData().size());
        assertFalse(repository.getAllData().contains(data1));
        assertTrue(repository.getAllData().contains(data2));
    }

    /**
     * Test of updateById method, of class GenericRepository.
     */
    @Test
    public void testUpdateById() {
        System.out.println("updateById");
        Player data1 = new Player(1, "Data 1");
        Player data2 = new Player(2, "Data 2");
        repository.saveData(data1);
        repository.saveData(data2);

        Player updatedData = new Player(1, "Updated Data 1");
        boolean updateResult = repository.updateById(1, updatedData);

        assertTrue(updateResult);
        assertEquals(updatedData, repository.getData(0));
    }

    /**
     * Test of getId method, of class GenericRepository.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Player data = new Player(1, "Data 1");
        repository.saveData(data);

        Integer id = repository.getId(data);

        assertNotNull(id);
        assertEquals(data.getId(), id);
    }

    private static class Player implements GenericInterface {
        private Integer id;
        private String name;

        public Player(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Player other = (Player) obj;
            return id.equals(other.id) && name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }
}
