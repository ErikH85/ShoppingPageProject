package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        @GetMapping("/addproduct")
        public String addProduct(@RequestParam String id, HttpServletRequest request) {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userID") != null) {
                int userID = (int) session.getAttribute("userID");
                int productId = Integer.parseInt(id);
                LPrepository.addProduct(productId,userID);
                return "redirect:/";
            }
            return "redirect:/";
        }
}
