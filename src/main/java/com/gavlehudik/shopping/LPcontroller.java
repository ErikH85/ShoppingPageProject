package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LPcontroller {

        @Autowired
        private LpRepository LPrepository;
        
        @GetMapping("/konsoller")
        public String konsoller(Model model) {
            model.addAttribute("Products",LPrepository.getConsoles());
            return "index";
        }
        @GetMapping("/spel")
        public String spel(Model model) {
            model.addAttribute("Products",LPrepository.getGames());
            return "index";
        }
}
