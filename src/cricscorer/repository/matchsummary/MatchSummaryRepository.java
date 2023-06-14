package cricscorer.repository.matchsummary;

import cricscorer.Model.MatchSummary;
import cricscorer.mysqlconnection.MySqlConnection;
import cricscorer.repository.generic.genericrepository.GenericRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.sql.*;

public class MatchSummaryRepository extends GenericRepository<MatchSummary, Integer> {

    public List<MatchSummary> returnMatchSummaryByBatsmenId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        Field field = MatchSummary.class.getDeclaredField("batsMenId");
        return matchSummaryRepository.getListByField(field, id);
    }

    public List<MatchSummary> returnMatchSummaryByBowlerId(MatchSummaryRepository matchSummaryRepository, Integer id) throws NoSuchFieldException {
        Field field = MatchSummary.class.getDeclaredField("bowlerId");
        return matchSummaryRepository.getListByField(field, id);
    }

    @Override
    public Integer getId(MatchSummary item) {
        return item.getId();
    }

    private final MySqlConnection mySqlConnection = new MySqlConnection();

    public Boolean insertDataToDatabase(MatchSummary matchSummary) throws SQLException {
        String insertQuery = "INSERT INTO match_summary VALUES (?, ?,?,?,?,?,?)";
        try {
            Connection connection = mySqlConnection.returnConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, matchSummary.getId());
            preparedStatement.setInt(2, matchSummary.getBatsMenId());
            preparedStatement.setInt(3, matchSummary.getBowlerId());
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, matchSummary.getRun());
            preparedStatement.setString(6, matchSummary.getAction().toString());
            preparedStatement.setDouble(7, matchSummary.getOver());
            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return true;
    }
}
