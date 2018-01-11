
public class App {

	public static void main(String[] args) {

		League league = new League();

		// creates soccer teams by team name, season wins and season ties
		league.addTeam(new SoccerTeam("Columbus Crew", 16, 6));
		league.addTeam(new SoccerTeam("Toronto FC", 20, 9));
		league.addTeam(new SoccerTeam("NYC FC", 19, 9));

		league.showLeagueRankings();

	}

}
