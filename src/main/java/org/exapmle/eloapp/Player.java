package org.exapmle.eloapp;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private String name;
    private int winCount;
    private int rating;
    private int delta;
    private ArrayList<Game> gamesBank;
    private int lossCount;
    private DefaultSettings defaultSettings;




    public Player(String name) {
        defaultSettings = new DefaultSettings();
        this.name = name;
        gamesBank = new ArrayList<>();
        winCount = 0;
        lossCount = 0;
        rating = defaultSettings.getDefaultRating();
        delta = rating - defaultSettings.getDefaultRating();
    }


    public int numberOfGamesPlayed() {
        return gamesBank.size();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Game> getGamesBank() {
        return gamesBank;
    }

    public void addGametoGamesBank(Game gamePlayed) {
        gamesBank.add(gamePlayed);
    }

    public int getNumberOfGamesPlayed() {
        return gamesBank.size();
    }

    public void incrementWinCount() {
        winCount += 1;
    }

    public void incrementLossCount() {
        lossCount += 1;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public int winLoss() {
        return Math.round(((float)winCount / (float)numberOfGamesPlayed() * 100));
    }

    public static Comparator<Player> Rating = new Comparator<Player>() {
        public int compare(Player player1, Player player2) {
            int ratingNo1 = player1.getRating();
            int ratingNo2 = player2.getRating();
            return ratingNo2 - ratingNo1;
        }
    };

}
