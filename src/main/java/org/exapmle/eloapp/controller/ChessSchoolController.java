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

    @GetMapping("/schools")
    public String school(Map<String, Object> model) {
        Iterable<Player> players = playerRepo.findAll();
        model.put("players", players);

        Iterable<ChessSchool> schools = chessSchoolRepo.findAll();
        model.put("schools", schools);

        return "schoolPage";
    }

    @GetMapping("/addschool")
    public String addschool(Map<String, Object> model) {

        return "addSchoolPage";
    }

    @PostMapping("/addschool")
    public String add(@RequestParam String schoolName, Map<String, Object> model) {
        //check that such a school does not exist
        ChessSchool chessSchool1 = chessSchoolRepo.findByName(schoolName).orElse(null);
        if (chessSchool1 == null) {
            //save the new school in the database
            ChessSchool chessSchool = new ChessSchool(schoolName);
            //transferring a new school
            model.put("newSchools", List.of(chessSchoolRepo.save(chessSchool)));
        } else {
            //school already exists
            model.put("oldSchools", List.of(chessSchoolRepo.save(chessSchool1)));
        }

        //transfer all schools
        Iterable<ChessSchool> schools = chessSchoolRepo.findAll();
        model.put("schools", schools);
        return "schoolPage";
    }
}
