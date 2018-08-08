package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RFController {

    @Autowired
    private ILRepository ilRepository;


    @GetMapping("/Index")
    private String getIndex(){
        return "Index";
    }

    @GetMapping("/SH")
    private String getSH() {
        return "SH";
    }

    @PostMapping("/Login")
    public String postRF(@RequestParam String email, @RequestParam String password, @RequestParam String firstname, @RequestParam String lastname,
                         @RequestParam String address, @RequestParam int zipcode, @RequestParam String state, @RequestParam String country,
                         HttpServletRequest request) {

        ILRepository.addUser(email, password, firstname, lastname, address, zipcode, state, country);
        return "Index";

    }

}





