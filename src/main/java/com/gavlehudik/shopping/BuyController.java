package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BuyController {

    @Autowired
    private BuyRepository buyRepository;

    @GetMapping("/buy")
    public ModelAndView getAddress(HttpServletRequest request){

        List<String> addresses;


        //HttpSession session = request.getSession(true);
        //User user = (User) session.getAttribute("user");
        //addresses = confirmRepository.getAddress(user.getEmail());



        addresses = buyRepository.getAddress("1");

        return new ModelAndView("buy").addObject("allAddresses", addresses);
    }

    @PostMapping("/buy")
    public String postForm(@RequestParam String addressRadio,
                           @RequestParam String paymentRadio){

        String addressOption = addressRadio;
        String paymentOption = paymentRadio;
        System.out.println(addressOption + " " + paymentOption);

        return "buy";

    }

}
