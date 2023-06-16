package cricscorer.controller.dashboard;

import cricscorer.mysqlconnection.MySqlConnection;
import cricscorer.repository.match.MatchRepository;
import cricscorer.repository.matchsummary.MatchSummaryRepository;
import cricscorer.repository.player.PlayerRepository;
import cricscorer.repository.playerteamtournament.PlayerTeamTournamentRepository;
import cricscorer.repository.team.TeamRepository;
import cricscorer.repository.teammatchscore.TeamMatchScoreRepository;
import cricscorer.repository.teamtournament.TeamTournamentRepository;
import cricscorer.repository.tournament.TournamentRepository;
import cricscorer.service.Match.MatchServiceImpl;

public class DashboardController {

    TeamMatchScoreRepository teamMatchScoreRepository;

    MatchRepository matchRepository;

    MatchSummaryRepository matchSummaryRepository;

    PlayerRepository playerRepository;

    PlayerTeamTournamentRepository playerTeamTournamentRepository;

    TeamRepository teamRepository;

    TeamTournamentRepository teamTournamentRepository;

    TournamentRepository tournamentRepository;

    CreateEntitiesDashboardController createEntitiesDashboard;

    MatchDashboardController matchDashboardController;

    UpdateEntitiesDashboardController updateEntitiesDashboard;

    ViewStatisticsDashboardController viewStatisticsDashboard;
    
    DeleteDashboard deleteDashboard;
    
    MySqlConnection mySqlConnection;

    public DashboardController() {
        matchDashboardController = new MatchDashboardController(new MatchServiceImpl());
        createEntitiesDashboard = new CreateEntitiesDashboardController();
        updateEntitiesDashboard = new UpdateEntitiesDashboardController();
        viewStatisticsDashboard = new ViewStatisticsDashboardController();
        teamMatchScoreRepository = new TeamMatchScoreRepository();
        matchSummaryRepository = new MatchSummaryRepository();
        playerRepository = new PlayerRepository();
        playerTeamTournamentRepository = new PlayerTeamTournamentRepository();
        teamRepository = new TeamRepository();
        teamTournamentRepository = new TeamTournamentRepository();
        tournamentRepository = new TournamentRepository();
        matchRepository = new MatchRepository();
        mySqlConnection=new MySqlConnection();
        deleteDashboard=new DeleteDashboard();
    }

    public MatchDashboardController getMatchDashboardController() {
        return matchDashboardController;
    }

    public CreateEntitiesDashboardController getCreateEntitiesDashboard() {
        return createEntitiesDashboard;
    }

    public MatchRepository getMatchRepository() {
        return matchRepository;
    }

    public MatchSummaryRepository getMatchSummaryRepository() {
        return matchSummaryRepository;
    }

    public PlayerTeamTournamentRepository getPlayerTeamTournamentRepository() {
        return playerTeamTournamentRepository;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public TeamMatchScoreRepository getTeamMatchScoreRepository() {
        return teamMatchScoreRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public TeamTournamentRepository getTeamTournamentRepository() {
        return teamTournamentRepository;
    }

    public TournamentRepository getTournamentRepository() {
        return tournamentRepository;
    }

    public UpdateEntitiesDashboardController getUpdateEntitiesDashboard() {
        return updateEntitiesDashboard;
    }

    public ViewStatisticsDashboardController getViewStatisticsDashboard() {
        return viewStatisticsDashboard;
    }

    public void setCreateEntitiesDashboard(CreateEntitiesDashboardController createEntitiesDashboard) {
        this.createEntitiesDashboard = createEntitiesDashboard;
    }

    public void setMatchDashboardController(MatchDashboardController matchDashboardController) {
        this.matchDashboardController = matchDashboardController;
    }

    public void setMatchRepository(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void setMatchSummaryRepository(MatchSummaryRepository matchSummaryRepository) {
        this.matchSummaryRepository = matchSummaryRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void setPlayerTeamTournamentRepository(PlayerTeamTournamentRepository playerTeamTournamentRepository) {
        this.playerTeamTournamentRepository = playerTeamTournamentRepository;
    }

    public void setTeamMatchScoreRepository(TeamMatchScoreRepository teamMatchScoreRepository) {
        this.teamMatchScoreRepository = teamMatchScoreRepository;
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void setTeamTournamentRepository(TeamTournamentRepository teamTournamentRepository) {
        this.teamTournamentRepository = teamTournamentRepository;
    }

    public void setUpdateEntitiesDashboard(UpdateEntitiesDashboardController updateEntitiesDashboard) {
        this.updateEntitiesDashboard = updateEntitiesDashboard;
    }

    public void setTournamentRepository(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public void setViewStatisticsDashboard(ViewStatisticsDashboardController viewStatisticsDashboard) {
        this.viewStatisticsDashboard = viewStatisticsDashboard;
    }

    public void setMySqlConnection(MySqlConnection mySqlConnection) {
        this.mySqlConnection = mySqlConnection;
    }

    public void setDeleteDashboard(DeleteDashboard deleteDashboard) {
        this.deleteDashboard = deleteDashboard;
    }

    public DeleteDashboard getDeleteDashboard() {
        return deleteDashboard;
    }

     public MySqlConnection getMySqlConnection() {
        return mySqlConnection;
    }
}
