import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

public class SoccerPlayoffTests {

	@Test
	public void shouldCreateASoccerTeam() {
		SoccerTeam underTest = new SoccerTeam();

		assertNotNull(underTest);
	}

	@Test
	public void shouldCreateASoccerTeamWithData() {
		SoccerTeam underTest = new SoccerTeam(null, 0, 0);

		assertNotNull(underTest);
	}

	@Test
	public void assertThatPointsIsThreeWithOneWin() {
		SoccerTeam underTest = new SoccerTeam("Columbus Crew", 1, 0);
		int check = underTest.seasonPointTotal();

		assertEquals(3, check);
	}

	@Test
	public void assertThatPointsIsFourWithOneWinAndOneDraw() {
		SoccerTeam underTest = new SoccerTeam("Columbus Crew", 1, 1);
		int check = underTest.seasonPointTotal();

		assertEquals(4, check);
	}

	@Test
	public void assertThatColumbus2017SeasonalPointTotalWas54() {
		SoccerTeam underTest = new SoccerTeam("Columbus Crew", 16, 6);
		int check = underTest.seasonPointTotal();

		assertEquals(54, check);
	}

	@Test
	public void assertThatSeasonPointTotalsAreSame() {
		SoccerTeam underTest = new SoccerTeam("Team 1", 1, 1);
		SoccerTeam underTest2 = new SoccerTeam("Team 2", 1, 1);
		int check = underTest.compareTo(underTest2);

		assertEquals(0, check);
	}

	@Test
	public void assertThatSeasonPointTotalIsOfLowerRank() {
		SoccerTeam underTest = new SoccerTeam("Team 1", 1, 2);
		SoccerTeam underTest2 = new SoccerTeam("Team 2", 1, 1);
		int check = underTest.compareTo(underTest2);

		assertEquals(-1, check);
	}

	@Test
	public void assertThatSeasonPointTotalIsOfHigherRank() {
		SoccerTeam underTest = new SoccerTeam("Team 1", 1, 1);
		SoccerTeam underTest2 = new SoccerTeam("Team 2", 1, 2);
		int check = underTest.compareTo(underTest2);

		assertEquals(1, check);
	}

	@Test
	public void assertThatMoreWinsBreaksSeasonalPointTotalTie() {
		SoccerTeam underTest = new SoccerTeam("Team 1", 1, 3);
		SoccerTeam underTest2 = new SoccerTeam("Team 2", 2, 0);
		int check = underTest.compareTo(underTest2);

		assertEquals(1, check);
	}

	@Test
	public void sortBySeasonPointTotal() {
		ArrayList<SoccerTeam> teams = new ArrayList<>();
		League league = new League();

		teams.add(new SoccerTeam("Columbus", 16, 6));
		teams.add(new SoccerTeam("Toronto", 20, 9));
		teams.add(new SoccerTeam("NY", 19, 9));

		when(league.showLeagueRankings()).thenReturn(teams);

		assertEquals("Toronto", teams.get(0).getTeamName());
		assertEquals("NY", teams.get(1).getTeamName());
		assertEquals("Columbus", teams.get(2).getTeamName());

	}

}
