package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmRepository confirmRepository;

    @Autowired
    private SHRepository shRepository;


    @GetMapping("/confirm")
    public ModelAndView getOrder(HttpServletRequest request, Model model){
        model.addAttribute("confirm", true);

        List<ShoppingCart> shoppingCartInventory;
        HttpSession session = request.getSession(true);


        String payment = "";

        if(session.getAttribute("LoggedIn") != null){
            int id = (int)session.getAttribute("userID");
            shoppingCartInventory = shRepository.getShoppingCart(Integer.toString(id));

            int paymentOption = (int) session.getAttribute("paymentOption");

            switch (paymentOption){
                case 0:
                    payment = "Visa";
                    break;
                case 1:
                    payment = "MasterCard";
                    break;
                case 2:
                    payment = "Klarna";
                    break;

            }

            System.out.println(payment);


            return new ModelAndView("index").addObject("shoppingCartInventory", shoppingCartInventory)
                    .addObject("paymentOption", payment);

        }
        else{
            return new ModelAndView("index");
        }
    }

    @PostMapping("/confirm")
    public String emptyShoppingCart(HttpServletRequest request){

        HttpSession session = request.getSession(true);
        if(session.getAttribute("LoggedIn") != null) {
            int id = (int) session.getAttribute("userID");
            confirmRepository.removeFromCart(id);
        }
            return "index";
    }

}
