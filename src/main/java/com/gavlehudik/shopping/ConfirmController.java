package com.gavlehudik.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConfirmController {


    @GetMapping("/confirm")
    public String getConfirmPage(){
        return "confirm";
    }

    @PostMapping("/confirm")
    public String postForm(@RequestParam String addressRadio,
                         @RequestParam String paymentRadio,
                         HttpServletRequest request){

        String addressOption = addressRadio;
        String paymentOption = paymentRadio;
        System.out.println(addressOption + " " + paymentOption);

        return "confirm";

    }


}
