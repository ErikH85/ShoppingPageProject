package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


@Controller
public class ILController {

    @Autowired
    private ILRepository ilRepository;


    @GetMapping("/")
    private String getIndex(){
        return "index";
    }


    @GetMapping("/login")
    public String LogInUser (HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session.getAttribute("LoggedIn") !=null) {
            System.out.println("inloggad");

        } else {
            System.out.println("utloggad");
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String getUserInput(@RequestParam (name="email")String email, @RequestParam(name="password")String password,
                               HttpServletRequest request) throws SQLException {

        String pw = ilRepository.verifyLogin(email);
        if(pw.equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("LoggedIn", true);
            int userID = ilRepository.getUserID(email);
            session.setAttribute("userID",userID);
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String removeSessionCookie(HttpServletResponse response,
                             HttpServletRequest request) {
        Cookie sessionCookie = new Cookie("JSESSIONID", null);
        sessionCookie.setMaxAge(0);
        response.addCookie(sessionCookie);
        HttpSession session = request.getSession(true);
        session.invalidate();
        return "index";
    }
}

