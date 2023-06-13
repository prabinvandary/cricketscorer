package cricscorer.repository.player;

import cricscorer.Model.Player;
import cricscorer.mysqlconnection.MySqlConnection;
import cricscorer.repository.generic.GenericRepository;

public class PlayerRepository extends GenericRepository<Player> {

    MySqlConnection connection = new MySqlConnection();

    void savePlayer() throws ClassNotFoundException {
        connection.returnConnection();
    }

}
