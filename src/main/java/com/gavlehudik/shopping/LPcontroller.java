package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        @GetMapping("/accessories")
        public String accessories(Model model) {
        model.addAttribute("Products",LPrepository.getAccessories());
        return "index";
        }

        @GetMapping("/phones")
        public String phones(Model model) {
        model.addAttribute("Products",LPrepository.getPhones());
        return "index";
        }

        @PostMapping("/addproduct/{id}")
        public String addProduct(@PathVariable String id, @RequestParam String numberOfItems, HttpServletRequest request) {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("userID") != null) {
                int userID = (int) session.getAttribute("userID");
                int productId = Integer.parseInt(id);
                int amount = Integer.parseInt(numberOfItems);
                System.out.println(id);
                System.out.println(amount);
                LPrepository.addProduct(productId,userID, amount);
                return "redirect:/";
            }
            return "redirect:/";
        }
}
