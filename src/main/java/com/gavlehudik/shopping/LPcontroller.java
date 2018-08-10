package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LPcontroller {

        @Autowired
        private LpRepository LPrepository;
        
        @GetMapping("/consoles")
        public String consoles(Model model) {
            model.addAttribute("Products",LPrepository.getConsoles());
            return "index";
        }
        @GetMapping("/games")
        public String games(Model model) {
            model.addAttribute("Products",LPrepository.getGames());
            return "index";
        }
}
