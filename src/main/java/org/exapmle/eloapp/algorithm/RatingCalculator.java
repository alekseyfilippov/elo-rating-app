package org.exapmle.eloapp.algorithm;

import org.exapmle.eloapp.domain.Game;
import org.exapmle.eloapp.domain.Player;

public class RatingCalculator {
    private Player player1;
    private Player player2;
    private Game game;

    private int proRatingBoundry = 2400;
    private int starterBoundary = 30;
    private int defaultRating = 2000;
    private int defaultKFactor = 10;

    public RatingCalculator(Game game) {
        this.proRatingBoundry = getProRatingBoundry();
        this.starterBoundary = getStarterBoundary();
        this.defaultRating = getDefaultRating();
        this.defaultKFactor = getDefaultKFactor();

        this.game = game;
        this.player1 = game.getPlayers().get(0);
        this.player2 = game.getPlayers().get(1);
        updatePlayerRating(player1, player2);
        updatePlayerDelta(player1, player2);
    }

    public RatingCalculator() {

    }


    public int getProRatingBoundry() {
        return proRatingBoundry;
    }

    public int getStarterBoundary() {
        return starterBoundary;
    }

    public int getDefaultRating() {
        return defaultRating;
    }

    public int getDefaultKFactor() {
        return defaultKFactor;
    }

    public void setstarterBoundary(int starterBoundary) {
        this.starterBoundary = starterBoundary;
    }

    public double transformedRating(Player player) {
        return Math.pow(10, (player.getRating()/400));
    }

    public double expectedScore(Player firstPlayer, Player secondPlayer) {
        double firstPlayerTranRating = this.transformedRating(firstPlayer);
        double secondPlayerTranRating = this.transformedRating(secondPlayer);
        return firstPlayerTranRating / (firstPlayerTranRating + secondPlayerTranRating);
    }

    public int newRating(Player primaryPlayer, Player otherPlayer) {
        double updatedRating = primaryPlayer.getRating() + this.kFactor(primaryPlayer) * (this.getScore(primaryPlayer) - this.expectedScore(primaryPlayer, otherPlayer));
        int rounded = (int) Math.round(updatedRating);
        return rounded;
    }

    public int newDelta(Player primaryPlayer, Player otherPlayer) {
        double updatedDelta =
                primaryPlayer.getRating() + this.kFactor(primaryPlayer) * (this.getScore(primaryPlayer) - this.expectedScore(primaryPlayer, otherPlayer)) - this.getDefaultRating();
        int rounded = (int) Math.round(updatedDelta);
        return rounded;
    }

    public int getScore(Player player) {
        if (player.equals(game.getWinner())) return 1;
        return 0;
    }

    public int kFactor(Player player) {
        if (player.numberOfGamesPlayed() < this.getStarterBoundary()) return 25;
        if (player.getRating() < this.getProRatingBoundry()) return 15;
        return this.getDefaultKFactor();
    }

    public void updatePlayerRating(Player firstPlayer, Player secondPlayer) {
        int firstNewRating = this.newRating(firstPlayer, secondPlayer);
        int secondNewRating = this.newRating(secondPlayer, firstPlayer);
        firstPlayer.setRating(firstNewRating);
        secondPlayer.setRating(secondNewRating);
    }

    public void updatePlayerDelta(Player firstPlayer, Player secondPlayer) {
        int firstNewDelta = this.newDelta(firstPlayer, secondPlayer);
        int secondNewDelta = this.newDelta(secondPlayer, firstPlayer);
        firstPlayer.setDelta(firstNewDelta);
        secondPlayer.setDelta(secondNewDelta);

    }

}
