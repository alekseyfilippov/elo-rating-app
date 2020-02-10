package org.exapmle.eloapp;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private DefaultSettings defaultsettings;
    private Player player1;
    private Player player2;
    private int player1score;
    private int player2score;


    public Game(Player player1, int player1score, Player player2, int player2score) {
        this.player1score = player1score;
        this.player2score = player2score;
        this.player1 = player1;
        this.player2 = player2;
        defaultsettings = new DefaultSettings();
        this.players = new ArrayList<>();
        this.addPlayersToGame(player1, player2);
        this.addGameToPlayerGamesBank(player1, player2);
    }

    public void addPlayersToGame(Player firstPlayer, Player secondPlayer) {
        players.add(firstPlayer);
        players.add(secondPlayer);
    }

    public void addGameToPlayerGamesBank(Player firstPlayer, Player secondPlayer) {
        firstPlayer.addGametoGamesBank(this);
        secondPlayer.addGametoGamesBank(this);
    }

    public Player getWinner() {
        if (player1score > player2score) return player1;
        return player2;
    }

    public Player getLoser() {
        if (player1score > player2score) return player2;
        return player1;
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }
}
