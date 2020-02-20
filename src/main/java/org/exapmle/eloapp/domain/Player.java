package org.exapmle.eloapp.domain;

import org.exapmle.eloapp.algorithm.RatingCalculator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String surname;
    private Double elo;

    @ManyToOne(fetch = FetchType.EAGER)
    private ChessSchool chessSchool;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GameDetails> matchDetails;

    public Player() {
    }

    public Player(String name, String lastname, String surname, ChessSchool school) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.elo = 400d;
        this.chessSchool = chessSchool;
    }

    public Player(String name, String lastname, String surname, Double elo, ChessSchool chessSchool) {
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.elo = elo;
        this.chessSchool = chessSchool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getElo() {
        return elo;
    }

    public void setElo(Double elo) {
        this.elo = elo;
    }

    public ChessSchool getSchool() {
        return chessSchool;
    }

    public void setSchool(ChessSchool school) {
        this.chessSchool = school;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + lastname + " " + elo + " [" + chessSchool + ']';
    }
}