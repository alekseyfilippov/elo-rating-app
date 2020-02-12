package org.exapmle.eloapp;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
    private String name;
    private String school;
    private int rating;
    private int delta;
    private ArrayList<Game> gamesBank;
    private DefaultSettings defaultSettings;


    public Player() {

    }

    public Player(String name, String school) {
        defaultSettings = new DefaultSettings();
        this.name = name;
        this.school = school;
        gamesBank = new ArrayList<>();
        rating = defaultSettings.getDefaultRating();
        delta = rating - defaultSettings.getDefaultRating();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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

    public void incrementWinCount() {
    }

    public void incrementLossCount() {
    }

    public static Comparator<Player> Rating = new Comparator<Player>() {
        public int compare(Player player1, Player player2) {
            int ratingNo1 = player1.getRating();
            int ratingNo2 = player2.getRating();
            return ratingNo2 - ratingNo1;
        }
    };

    public static Comparator<Player> Delta = new Comparator<Player>() {
        public int compare(Player player1, Player player2) {
            int deltaNo1 = player1.getDelta();
            int deltaNo2 = player2.getDelta();
            return deltaNo2 - deltaNo1;
        }
    };

}
