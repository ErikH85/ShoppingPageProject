package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;


    @GetMapping("/login")
    public String AddToCart(HttpServletRequest request){
    HttpSession cartSession = request.getSession(true);
    cartSession.setAttribute("newProduct", request.getProduct("Referer"));

    Cart previousItems = (Cart)cartSession.getAttribute("previousItems");

        if (previousItems == null) {
        previousItems = new Cart(@RequestParam("productname"), @RequestParam("cost"), @RequestParam("quantity"), HttpServletRequest request);
    }

    String itemID = request.getParameter("itemID");
    previousItems.addObject(Catalog.getEntry(itemID));


    cartSession.setAttribute("previousItems", previousItems);

    }
}



