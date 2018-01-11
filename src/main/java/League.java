import java.util.ArrayList;
import java.util.Collections;

public class League {

	private ArrayList<SoccerTeam> teams = new ArrayList<>();

	public void addTeam(SoccerTeam team) {
		teams.add(team);
	}

	public ArrayList<SoccerTeam> showLeagueRankings() {
		Collections.sort(teams);
		for (SoccerTeam team : teams) {
			System.out.println(team.getTeamName() + " : " + team.seasonPointTotal());
		}
		return teams;
	}

}
