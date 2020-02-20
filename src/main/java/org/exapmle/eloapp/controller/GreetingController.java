package org.exapmle.eloapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        model.put("playerslist", "Players not added");
        return "greeting";
    }
}
