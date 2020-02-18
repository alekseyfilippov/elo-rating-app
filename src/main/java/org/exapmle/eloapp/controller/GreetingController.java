package org.exapmle.eloapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "redirect:/bestplayers";
    }
}
