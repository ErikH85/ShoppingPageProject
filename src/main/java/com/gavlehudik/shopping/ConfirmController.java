package com.gavlehudik.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ConfirmController {


    @GetMapping("/confirm")
    public String getOrder(){

        return "confirm";
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
