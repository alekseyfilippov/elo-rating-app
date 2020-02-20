package org.exapmle.eloapp.domain;

import org.exapmle.eloapp.algorithm.RatingCalculator;
import org.exapmle.eloapp.repository.GameDetailsRepo;
import org.exapmle.eloapp.repository.GameRepo;
import org.exapmle.eloapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class Match {
    @Autowired
    private GamePair gamePair;
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private GameDetailsRepo gameDetailsRepo;
    @Autowired
    private GameRepo gameRepo;

    public Match(GamePair gamePair) {
        this.gamePair = gamePair;
    }

    public void start() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //get a couple of random players
                    Player[] players = gamePair.getGamePair();
                    //check that players exist
                    if (players != null) {
                        //randomly select a winner
                        Random rnd = new Random((System.currentTimeMillis()));
                        int win1 = rnd.nextInt(3);
                        int win2 = 2; //draw
                        if (win1 == 0) // losе
                            win2 = 1; //win
                        if (win1 == 1) //win
                            win2 = 0; //lose
                        System.out.println(win1);
                        System.out.println("Первый игрок: " + players[0]);
                        System.out.println("Второй игрок: " + players[1]);

                        try {
                            //keep the original values of the players elo
                            double elo1 = players[0].getElo();
                            double elo2 = players[1].getElo();

                            //change the first player’s elo
                            players[0].setElo(RatingCalculator.getElo(players[0].getElo(), players[1].getElo(), win1));
                            playerRepo.save(players[0]);

                            //change the elo of the second player
                            players[1].setElo(RatingCalculator.getElo(players[1].getElo(), players[0].getElo(), win2));
                            playerRepo.save(players[1]);
                            System.out.println("РЕЗУЛЬТАТЫ:");
                            System.out.println("Первый игрок: " + players[0]);
                            System.out.println("Второй игрок: " + players[1]);

                            //save game data
                            Game game = new Game();
                            gameRepo.save(game);
                            //save data in gamedetails about the first player
                            GameDetails gameDetails = new GameDetails(players[0], win1, game, Math.round((players[0].getElo() - elo1) * 10) / 10d);
                            gameDetailsRepo.save(gameDetails);
                            //save data to gamedetails about the second player
                            gameDetails = new GameDetails(players[1], win1, game, Math.round((players[1].getElo() - elo2) * 10) / 10d);
                            gameDetailsRepo.save(gameDetails);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

    }
}
