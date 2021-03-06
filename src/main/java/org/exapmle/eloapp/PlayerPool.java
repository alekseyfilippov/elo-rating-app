package org.exapmle.eloapp;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerPool {
    private ArrayList<Player> players;

    public PlayerPool() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void sortPlayersByRanking() {
        Collections.sort(players, Player.Rating);
    }
    public void sortPlayersByDelta() {
        Collections.sort(players, Player.Delta);
    }

    public void printNewRatings() {
        System.out.println("--------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s", "RANKING", "NAME", "SCHOOL", "RATING", "DELTA");
        System.out.println();
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < players.size(); i++){
            int rank = i;
            System.out.format("%10s %10s %10s %10d %10s",
                    rank + 1, players.get(i).getName(), players.get(i).getSchool(), players.get(i).getRating(),
                    players.get(i).getDelta());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
    }

    public void printFirstFive() {
        System.out.println("--------------------------------------------------------");
        System.out.printf("%10s %10s %10s %10s %10s", "RANKING", "NAME", "SCHOOL", "RATING", "DELTA");
        System.out.println();
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < 5; i++){
            int rank = i;
            System.out.format("%10s %10s %10s %10d %10s",
                    rank + 1, players.get(i).getName(), players.get(i).getSchool(), players.get(i).getRating(),
                    players.get(i).getDelta());
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
    }
}
