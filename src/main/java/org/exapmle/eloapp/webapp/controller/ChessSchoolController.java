package org.exapmle.eloapp.webapp.controller;

import org.exapmle.eloapp.webapp.domain.ChessSchool;
import org.exapmle.eloapp.webapp.domain.Player;
import org.exapmle.eloapp.webapp.repository.ChessSchoolRepo;
import org.exapmle.eloapp.webapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/chessschools")
    public String chessSchool(Map<String, Object> model) {
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chessschools", chessSchools);

        return "chessschools";
    }

    @GetMapping("/delchessschool/{id}")
    public String del(@PathVariable("id") int id, Map<String, Object> model) {
        ChessSchool chessSchool = chessSchoolRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid chess school id: " + id));
        chessSchoolRepo.delete(chessSchool);

        //get all the chess schools and pass them to display on the page
        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chessschools", chessSchools);

        return "chessschools";
    }

    @PostMapping("/chessschools")
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
//        ChessSchool chessSchool = new ChessSchool(chessSchoolName);
//        chessSchoolRepo.save(chessSchool);
//        model.put("newChessSchools", List.of(chessSchoolRepo.save(chessSchool)));
        //transfer all chess schools
        Iterable<ChessSchool> chessSchools = chessSchoolRepo.findAll();
        model.put("chessschools", chessSchools);
        return "chessschools";
    }
}
