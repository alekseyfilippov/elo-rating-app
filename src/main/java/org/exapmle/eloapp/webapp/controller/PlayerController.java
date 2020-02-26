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


//    @GetMapping("/players")
//    public String players(Map<String, Object> model) {
//        //get all the players and pass them to display on the page
//        Iterable<Player> players = playerRepo.findAll();
//        model.put("players", players);
//
//
//        return "players";
//    }

    @GetMapping("/players")
    public String addplayer(Map<String, Object> model) {
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chessschools", chessSchools);

        return "players";
    }

    @PostMapping("/players")
    public String add(@RequestParam String name, @RequestParam String patronymic, @RequestParam String surname, @RequestParam String chessSchool, Map<String, Object> model) {
        ChessSchool chessSchool1 = chessSchoolRepo.findByName(chessSchool).orElse(null);
        //check if there is a school with the given name
        if (chessSchool1 != null) {
            //create and save player
            Player player1 = new Player(name, patronymic, surname, chessSchool1);
            //transfer new player
            model.put("newPlayers", List.of(playerRepo.save(player1)));

            //get all the players and pass them to display on the page
            Iterable<Player> players = playerRepo.findAll();
            model.put("players", players);

            return "players";
        }
        System.out.println("School is not exist!");
        return "redirect:/chessschools";
    }

    @GetMapping("/delplayer/{id}")
    public String del(@PathVariable("id") int id, Map<String, Object> model) {
        Player player = playerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        playerRepo.delete(player);

        //get all the players and pass them to display on the page
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        return "redirect:/players";
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
