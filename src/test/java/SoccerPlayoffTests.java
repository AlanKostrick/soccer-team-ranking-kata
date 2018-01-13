import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoccerPlayoffTests {

	SoccerTeam underTest;
	SoccerTeam underTest2;

	@Before
	public void setup() {
		underTest = new SoccerTeam();
		underTest2 = new SoccerTeam();
	}

	@Test
	public void shouldCreateASoccerTeam() {

		assertNotNull(underTest);
	}

	@Test
	public void shouldCreateASoccerTeamWithData() {
		underTest = new SoccerTeam("", 0, 0);

		assertNotNull(underTest);
	}

	@Test
	public void assertThatPointsIsThreeWithOneWin() {
		underTest = new SoccerTeam("", 1, 0);
		int check = underTest.seasonPointTotal();

		assertEquals(3, check);
	}

	@Test
	public void assertThatPointsIsFourWithOneWinAndOneDraw() {
		underTest = new SoccerTeam("", 1, 1);
		int check = underTest.seasonPointTotal();

		assertEquals(4, check);
	}

	@Test
	public void assertThatColumbus2017SeasonalPointTotalWas54() {
		underTest = new SoccerTeam("Columbus Crew", 16, 6);
		int check = underTest.seasonPointTotal();

		assertEquals(54, check);
	}

	@Test
	public void assertThatSeasonPointTotalsAreSame() {
		underTest = new SoccerTeam("", 1, 1);
		underTest2 = new SoccerTeam("", 1, 1);
		int check = underTest.compareTo(underTest2);

		assertEquals(0, check);
	}

	@Test
	public void assertThatSeasonPointTotalIsOfLowerRank() {
		underTest = new SoccerTeam("", 1, 2);
		underTest2 = new SoccerTeam("", 1, 1);
		int check = underTest.compareTo(underTest2);

		assertEquals(-1, check);
	}

	@Test
	public void assertThatSeasonPointTotalIsOfHigherRank() {
		underTest = new SoccerTeam("", 1, 1);
		underTest2 = new SoccerTeam("", 1, 2);
		int check = underTest.compareTo(underTest2);

		assertEquals(1, check);
	}

	@Test
	public void assertThatMoreWinsBreaksSeasonalPointTotalTie() {
		underTest = new SoccerTeam("", 1, 3);
		underTest2 = new SoccerTeam("", 2, 0);
		int check = underTest.compareTo(underTest2);

		assertEquals(1, check);
	}

	@Test
	public void sortBySeasonPointTotal() {
		SoccerTeam columbus = new SoccerTeam("Columbus", 1, 1);
		SoccerTeam ny = new SoccerTeam("NY", 2, 2);
		SoccerTeam toronto = new SoccerTeam("Toronto", 3, 3);

		League league = new League();
		league.addTeam(columbus);
		league.addTeam(ny);
		league.addTeam(toronto);

		league.showLeagueRankings();

		// check for teams in order of rank in the sorted list
		assertEquals("Toronto", league.getTeamName(0));
		assertEquals("NY", league.getTeamName(1));
		assertEquals("Columbus", league.getTeamName(2));

	}

	@Test
	public void sortBySeasonPointTotalWithWinsTieBreakerBetweenTorontoAndNy() {
		SoccerTeam columbus = new SoccerTeam("Columbus", 1, 2);
		SoccerTeam ny = new SoccerTeam("NY", 1, 3);
		SoccerTeam toronto = new SoccerTeam("Toronto", 2, 0);

		League league = new League();
		league.addTeam(columbus);
		league.addTeam(ny);
		league.addTeam(toronto);

		league.showLeagueRankings();

		// check for teams in order of rank in the sorted list
		assertEquals("Toronto", league.getTeamName(0));
		assertEquals("NY", league.getTeamName(1));
		assertEquals("Columbus", league.getTeamName(2));

	}

}
