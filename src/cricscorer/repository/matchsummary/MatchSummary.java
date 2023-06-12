package cricscorer.repository.matchsummary;

import cricscorer.enumvalues.MatchBowlAction;
import cricscorer.mysqlconnection.MySqlConnection;
import java.sql.Connection;
import java.sql.Statement;

public class MatchSummary {
    private Integer id;
    private Integer run;
    private Double over;
    private MatchBowlAction action;
    private Integer batsMenId;
    private Integer bowlerId;
    private Integer matchId;
    String createTableStatement = "create table match_summary(id int primary key auto_increment,run int,venue varchar(255)";

    Boolean createMatchSummaryEntity() {
        try {
            MySqlConnection connection = new MySqlConnection();
            Connection con = connection.returnConnection();
            Statement stmt = con.createStatement();
            stmt.execute(createTableStatement);
        } catch (Exception e) {
            System.out.println(e);
        }

        return true;
    }
}
