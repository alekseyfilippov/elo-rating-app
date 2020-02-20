package org.exapmle.eloapp.webapp.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;


@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp gameTime;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GameDetails> gameDetails;

    public void setGameDetails(List<GameDetails> matchDetails) {
        this.gameDetails = matchDetails;
    }

    public List<GameDetails> getGameDetails() {
        return this.gameDetails;
    }

    public Game() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        long time = calendar.getTimeInMillis();

        this.gameTime = new Timestamp(time);
    }

    public Game(Timestamp gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMatchTime() {
        return gameTime;
    }

    public void setMatchTime(Timestamp matchTime) {
        this.gameTime = gameTime;
    }
}

