package org.exapmle.eloapp.domain;

import org.exapmle.eloapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


    @Component
    public class GamePair {
        private Player player1;
        private Player player2;
        @Autowired
        private PlayerRepo PlayerRepo;

        public GamePair() {
        }

        private void setPlayer1(Player player1) {
            this.player1 = player1;
        }

        private Player getPlayer1() {
            return player1;
        }

        private void setPlayer2(Player player2) {
            this.player2 = player2;
        }

        private Player getPlayer2() {
            return player2;
        }

        public Player[] getGamePair() {
            //get a list of all players
            Iterable<Player> allplayersIter = PlayerRepo.findAll();

            List<Player> allplayers = new ArrayList<>();
            allplayersIter.forEach(allplayers::add);

            if (allplayers.size() == 0)
                return null;

            //generate random number
            Random rnd = new Random((System.currentTimeMillis()));
            int rndInt = rnd.nextInt(allplayers.size());
            //take a random player
            setPlayer1(allplayers.get(rndInt));
            //delete it from the collection
            allplayers.remove(rndInt);

            //cycle until we find a school different from the school of the first player
            //Player rndplayer;
            Player rndplayer;
            //Player rndplayer=allplayers.get(rndInt)
            for (int i = 0; i < allplayers.size(); ) {
                //take a random player
                rndInt = rnd.nextInt(allplayers.size());
                rndplayer = allplayers.get(rndInt);
                //check for school equals
                if (!player1.getSchool().equals(
                        rndplayer.getSchool())) {
                    setPlayer2(rndplayer);
                    return new Player[]{player1, player2};
                } else {
                    //if it doesn’t fit, delete from the collection
                    allplayers.remove(rndInt);
                }

            }

            return null;
            //List<Player> player12 = PlayerRepo.findRandom(0, PageRequest.of(0, 10));
            //player1=player12.get(0);

        }

    }


