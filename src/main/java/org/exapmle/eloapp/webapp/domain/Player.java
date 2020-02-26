package org.exapmle.eloapp.webapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String patronymic;
    private String surname;
    private Double elo;

    @ManyToOne(fetch = FetchType.EAGER)
    private ChessSchool chessSchool;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GameDetails> gameDetails;

    public Player() {
    }

    public Player(String name, String patronymic, String surname, ChessSchool chessSchool) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.elo = 400d;
        this.chessSchool = chessSchool;
    }

    public Player(String name, String patronymic, String surname, Double elo, ChessSchool chessSchool) {
        this.name = name;
        this.patronymic = patronymic;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public ChessSchool getChessSchool() {
        return chessSchool;
    }

    public void setChessSchool(ChessSchool chessSchool) {
        this.chessSchool = chessSchool;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + elo + " [" + chessSchool + ']';
    }
}
