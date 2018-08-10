package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SHController {

    @Autowired
    private SHRepository shRepository;


    @GetMapping("/getShoppingCart")
    public ModelAndView displaySH(HttpServletRequest request){

        HttpSession session = request.getSession(true);

        List<ShoppingCart> shoppingCartInventory;

        if (session.getAttribute("LoggedIn") != null) {
            System.out.println("inloggad");


            int id = (Integer) session.getAttribute("userID");

            shoppingCartInventory = shRepository.getShoppingCart(Integer.toString(id));

            return new ModelAndView("index").addObject("shoppingCartInventory", shoppingCartInventory)
                    .addObject("shoppingCart",true);
        }
        else{
            return new ModelAndView("index");
        }
    }


}