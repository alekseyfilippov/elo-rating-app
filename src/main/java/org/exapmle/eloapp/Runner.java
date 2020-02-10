package org.exapmle.eloapp;

import java.util.ArrayList;
import java.util.Collections;

public class Runner {
    //PlayerPool
    private PlayerPool playerPool;

    //Required
    private DefaultSettings defaultSettings;
    private RatingCalculator ratingCalculator;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Runner(PlayerPool playerPool) {
        this.playerPool = playerPool;
        setUpPlayerPool();
    }

    public void setUpPlayerPool() {
        Player player1 = new Player("John");
        Player player2 = new Player("Adam");
        Player player3 = new Player("Beverly");
        Player player4 = new Player("Seth");
        Player player5 = new Player("Nikolas");
        Player player6 = new Player("Ivan");
        Player player7 = new Player("Bob");
        Player player8 = new Player("Matt");
        Player player9 = new Player("Kit");
        Player player10 = new Player("Jimbo");
        playerPool.addPlayer(player1);
        playerPool.addPlayer(player2);
        playerPool.addPlayer(player3);
        playerPool.addPlayer(player4);
        playerPool.addPlayer(player5);
        playerPool.addPlayer(player6);
        playerPool.addPlayer(player7);
        playerPool.addPlayer(player8);
        playerPool.addPlayer(player9);
        playerPool.addPlayer(player10);
    }

    public PlayerPool getPlayerPool(){
        return this.playerPool;
    }

    public ArrayList<Player> getRandomPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Collections.shuffle(playerPool.getPlayers());
        players.add(playerPool.getPlayers().get(0));
        players.add(playerPool.getPlayers().get(1));
        return players;
    }

    public int getRandomFirstScore() {
        return randomNumberGenerator.generateNumber(1);
    }

    public int getSecondScore(int firstScore) {
        if (firstScore == 0) return 1;
        return 0;
    }

    public void play1000Games() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            ArrayList<Player> players = getRandomPlayers();
            int firstScore = getRandomFirstScore();
            Game game = new Game(players.get(0), firstScore, players.get(1), getSecondScore(firstScore));
            System.out.println(game.getWinner().getName());
            RatingCalculator ratingCalculator = new RatingCalculator(game);
            System.out.println(game.getWinner().getRating());
            System.out.println(game.getLoser().getName());
            System.out.println(game.getLoser().getRating());
            System.out.println("-------");
            Thread.sleep(3000);
        }
        playerPool.sortPlayersByRanking();
        playerPool.printNewRatings();
    }


}
