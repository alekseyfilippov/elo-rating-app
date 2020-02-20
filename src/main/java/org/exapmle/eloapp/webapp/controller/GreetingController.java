package org.exapmle.eloapp.webapp.controller;

import org.exapmle.eloapp.webapp.repository.ChessSchoolRepo;
import org.exapmle.eloapp.webapp.repository.GameRepo;
import org.exapmle.eloapp.webapp.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        model.put("players", "Players not added");
        return "greeting";
    }
}
