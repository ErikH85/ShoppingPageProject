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
import java.sql.SQLException;


@Controller
public class ILController {

    @Autowired
    private ILRepository ilRepository;


    @GetMapping("/Index")
    private String getIndex(){
        return "Index";
    }
    @GetMapping("/Login")
    private String getLogin(){
        return "Login";

    }
    @GetMapping("/SH")
    private String getSH() {
        return "SH";
    }

    @GetMapping("/Login")
    public String LogInUser (HttpServletRequest request){
        HttpSession session = request.getSession(true);
        if(session.getAttribute("LoggedIn") !=null)
            return "allUsers";
        else
            return "redirect: Login";
    }

    @PostMapping("/Login")
    public String getUserInput(@RequestParam (name="email", required=true)String email, @RequestParam(name="password")String password,
                               HttpServletRequest request) throws SQLException {
        if(ilRepository.verifyLogin(email,password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("LoggedIn", true);
            return "redirect: Index";
        } else {
            return "Login";
        }
    }

    @GetMapping("/Logout")
    public String removeSessionCookie(HttpServletResponse respons, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.invalidate ();
        return "Index";
    }
}

