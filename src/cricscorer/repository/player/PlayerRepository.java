package cricscorer.repository.player;

import cricscorer.mysqlconnection.MySqlConnection;

public class PlayerRepository {

    MySqlConnection connection = new MySqlConnection();

    void savePlayer() throws ClassNotFoundException {
        connection.returnConnection();
    }

}
