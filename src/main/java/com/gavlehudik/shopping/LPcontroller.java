package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LPcontroller {

        @Autowired
        private LpRepository LPrepository;

        @GetMapping("/konsoller")
        public String login() {
                for(String n : LPrepository.getProducts()) {
                    System.out.println(n);
                }



            return "index";
        }
}
