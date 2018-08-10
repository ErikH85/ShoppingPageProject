package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmRepository confirmRepository;


    @GetMapping("/confirm")
    public ModelAndView getOrder(HttpServletRequest request, Model model){
        model.addAttribute("confirm", true);
        List<Order>  products;

        products = confirmRepository.getReceipt("1");
        return new ModelAndView("index").addObject("allProducts", products);
    }
}
