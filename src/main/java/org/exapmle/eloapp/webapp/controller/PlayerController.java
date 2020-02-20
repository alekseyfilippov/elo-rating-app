package org.exapmle.eloapp.webapp.controller;

import org.exapmle.eloapp.webapp.domain.ChessSchool;
import org.exapmle.eloapp.webapp.domain.Game;
import org.exapmle.eloapp.webapp.domain.GameDetails;
import org.exapmle.eloapp.webapp.domain.Player;
import org.exapmle.eloapp.webapp.repository.ChessSchoolRepo;
import org.exapmle.eloapp.webapp.repository.GameRepo;
import org.exapmle.eloapp.webapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private ChessSchoolRepo chessSchoolRepo;
    @Autowired
    private GameRepo gameRepo;


    @GetMapping("/players")
    public String players(Map<String, Object> model) {
        //get all the players and pass them to display on the page
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);


        return "players";
    }

    @GetMapping("/addplayer")
    public String addplayer(Map<String, Object> model) {
        //get all the players and pass them to display on the page
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        //get all the schools and pass them to display on the page
        Iterable<ChessSchool> schools = chessSchoolRepo.findAll();
        model.put("schools", schools);

        return "addplayer";
    }

    @PostMapping("/addplayer")
    public String add(@RequestParam String name, @RequestParam String surname, @RequestParam String lastname, @RequestParam String school, Map<String, Object> model) {
        ChessSchool chessSchool1 = chessSchoolRepo.findByName(school).orElse(null);
        //check if there is a school with the given name
        if (chessSchool1 != null) {
            //create and save player
            Player player = new Player(name, lastname, surname, chessSchool1);
            //transfer new player
            model.put("newPlayers", List.of(playerRepo.save(player)));

            //get all the players and pass them to display on the page
            Iterable<Player> players = playerRepo.findAll();
            model.put("players", players);

            return "players";
        }
        System.out.println("ERROR");
        return "error";
    }

    @GetMapping("/delplayer/{id}")
    public String del(@PathVariable("id") int id, Map<String, Object> model) {
        Player player = playerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        playerRepo.delete(player);

        //get all the players and pass them to display on the page
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        return "players";
    }

    @GetMapping("/bestratingchanges")
    public String best(Map<String, Object> model) {

        //Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -5);
        Date date = calendar.getTime();
        System.out.println(date.toString());
        List<Game> matchs = gameRepo.findByGameTimeAfter(date);


        Map<Player, Double> result = matchs.stream() //convert to stream
                // .map(Match::getGameDetails) //Game Details Map
                .flatMap(Match -> Match.getGameDetails().stream()) //Game Details Map

                .collect(Collectors.groupingBy(GameDetails::getPlayer, Collectors.summingDouble(GameDetails::getRatingChange)))

                .entrySet()
                .stream()
                .sorted(Map.Entry.<Player, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        model.put("players", result);

        return "bestratingchanges";

    }
}
