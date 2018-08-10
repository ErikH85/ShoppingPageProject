package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BuyController {

    @Autowired
    private BuyRepository buyRepository;

    @GetMapping("/buy")
    public ModelAndView getAddress(HttpServletRequest request, Model model) {
        model.addAttribute("buy", true);
        List<String> addresses;

        HttpSession session = request.getSession(true);

        if (session.getAttribute("LoggedIn") != null) {

            int id = (Integer)session.getAttribute("userID");
            addresses = buyRepository.getAddress(Integer.toString(id));

            return new ModelAndView("index").addObject("allAddresses", addresses);
        } else {
            System.out.println("utloggad");
            return new ModelAndView("redirect:/");
        }
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
