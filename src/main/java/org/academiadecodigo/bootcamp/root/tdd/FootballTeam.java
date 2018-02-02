package org.academiadecodigo.bootcamp.root.tdd;

public class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;

    public FootballTeam(int gamesWon) {
        if (gamesWon < 0) {
            throw new IllegalArgumentException("Illegal amount : [ " + gamesWon + "]");
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int compareTo(FootballTeam o) {
        if(o.gamesWon < this.gamesWon){
            return 1;
        }
        if(o.gamesWon > this.gamesWon){
            return -1;
        }
        return 0;
    }
}
