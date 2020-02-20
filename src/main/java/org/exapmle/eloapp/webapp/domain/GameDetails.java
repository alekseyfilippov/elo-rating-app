package org.exapmle.eloapp.webapp.domain;

import javax.persistence.*;

@Entity
public class GameDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;

    private Integer winner;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;

    private double ratingChange;

    public GameDetails() {
    }

    public GameDetails(Player player, Integer winner, Game game, double ratingChange) {
        this.player = player;
        this.winner = winner;
        this.game = game;
        this.ratingChange = ratingChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer isWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Game getGame() {
        return game;
    }

    public void setMatch(Game game) {
        this.game = game;
    }

    public double getRatingChange() {
        return ratingChange;
    }

    public void setRatingChange(double ratingChange) {
        this.ratingChange = ratingChange;
    }

    @Override
    public String toString() {
        return player + " is " + winner + " [" + ratingChange + "]";
    }
}
