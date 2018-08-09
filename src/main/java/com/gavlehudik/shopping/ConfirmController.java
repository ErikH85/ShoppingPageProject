package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmRepository confirmRepository;

    /*
    @GetMapping("/confirm")
    public String getOrder(){

        return "confirm";
    }
    */

    @GetMapping("/confirm")
    public ModelAndView getAddress(HttpServletRequest request){

        List<String> addresses;
        //HttpSession session = request.getSession(true);
        //User user = (User) session.getAttribute("user");
        //addresses = confirmRepository.getAddress(user.getEmail());

        addresses = confirmRepository.getAddress("christoffergunnarsson@hotmail.com");

        return new ModelAndView("confirm").addObject("allAddresses", addresses);
    }

    @PostMapping("/confirm")
    public String postForm(@RequestParam String addressRadio,
                           @RequestParam String paymentRadio){

        String addressOption = addressRadio;
        String paymentOption = paymentRadio;
        System.out.println(addressOption + " " + paymentOption);

        return "confirm";

    }




}
