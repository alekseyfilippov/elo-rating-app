package org.exapmle.eloapp.controller;

import org.exapmle.eloapp.domain.ChessSchool;
import org.exapmle.eloapp.domain.Player;
import org.exapmle.eloapp.repository.ChessSchoolRepo;
import org.exapmle.eloapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ChessSchoolController {
    @Autowired
    private ChessSchoolRepo chessSchoolRepo;
    @Autowired
    private PlayerRepo playerRepo;

    @GetMapping("/chess_schools")
    public String school(Map<String, Object> model) {
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chess schools", chessSchools);

        return "chessschools";
    }

    @GetMapping("/addchessschool")
    public String addChessSchool(Map<String, Object> model) {

        return "addchessschool";
    }

    @PostMapping("/addchessschool")
    public String add(@RequestParam String chessSchoolName, Map<String, Object> model) {
        //check that such a chess school does not exist
        ChessSchool chessSchool1 = chessSchoolRepo.findByName(chessSchoolName).orElse(null);
        if (chessSchool1 == null) {
            //save the new chess school in the database
            ChessSchool chessSchool = new ChessSchool(chessSchoolName);
            //transferring a new chess school
            model.put("newChessSchools", List.of(chessSchoolRepo.save(chessSchool)));
        } else {
            //school already exists
            model.put("oldChessSchools", List.of(chessSchoolRepo.save(chessSchool1)));
        }

        //transfer all chess schools
        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chess schools", chessSchools);
        return "chessschools";
    }
}
