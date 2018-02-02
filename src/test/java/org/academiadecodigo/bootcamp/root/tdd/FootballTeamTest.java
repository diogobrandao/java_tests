package org.academiadecodigo.bootcamp.root.tdd;

import org.junit.Test;

import  static  org.junit.Assert.*;

public class FootballTeamTest {

    private  static  final int VALID_NUMBER = 3;
    private  static final int INVALID_NUMBER = -3;

    @Test
    public void constructorShouldSetGamesWon(){

        FootballTeam footballteam = new FootballTeam(VALID_NUMBER);
        assertEquals(VALID_NUMBER + " Games passed to the constructor, but " + footballteam.getGamesWon() + " were returned", VALID_NUMBER, footballteam.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)  // o teste sabe q espera falhar e assim da como teste passado
    public void contructorShouldNotSetGamesWonBecuseInvalidNumber(){
        FootballTeam footballteam = new FootballTeam(INVALID_NUMBER);


    }

    @Test
    public  void shouldBePossibleToCompareTeams() {
        FootballTeam team = new FootballTeam(VALID_NUMBER);
        assertTrue("FootballTeam should implement Comparable", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreVictoriesShouldComeFirst(){
        FootballTeam footballTeam = new FootballTeam(VALID_NUMBER);
        FootballTeam footballTeam1 = new FootballTeam(4);
        assertEquals(-1,footballTeam.compareTo(footballTeam1));
        assertEquals(1,footballTeam1.compareTo(footballTeam));  //1 is bigger
    }

    @Test
    public void teamsWithLessVictoriesShouldComeAfter(){
        FootballTeam footballTeam = new FootballTeam(VALID_NUMBER);
        FootballTeam footballTeam1 = new FootballTeam(2);
        assertEquals(1, footballTeam.compareTo(footballTeam1));
        assertEquals(-1, footballTeam1.compareTo(footballTeam));   //-1 is smaller
    }

    @Test
    public void teamsWithSameShouldStayInSame(){
        FootballTeam footballTeam = new FootballTeam(VALID_NUMBER);
        FootballTeam footballTeam1 = new FootballTeam(VALID_NUMBER);
        assertEquals(0,footballTeam.compareTo(footballTeam1));  // 0 same
        assertEquals(0,footballTeam1.compareTo(footballTeam));
    }

}
