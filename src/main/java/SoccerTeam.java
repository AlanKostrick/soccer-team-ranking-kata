
public class SoccerTeam implements Comparable<SoccerTeam> {

	private String teamName;
	private int wins;
	private int draws;

	int points;

	public SoccerTeam() {

	}

	public SoccerTeam(String teamName, int wins, int draws) {
		this.teamName = teamName;
		this.wins = wins;
		this.draws = draws;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getWins() {
		return wins;
	}

	public int seasonPointTotal() {
		return wins * 3 + draws;
	}

	@Override
	public int compareTo(SoccerTeam team) {
		if (this.seasonPointTotal() > team.seasonPointTotal()) {
			return -1;
		} else if (this.seasonPointTotal() < team.seasonPointTotal()) {
			return 1;
		} else if (this.seasonPointTotal() == team.seasonPointTotal() && this.wins < team.wins) {
			return 1;
		} else if (this.seasonPointTotal() == team.seasonPointTotal() && this.wins > team.wins) {
			return -1;
		} else {
			return 0;
		}
	}

}
