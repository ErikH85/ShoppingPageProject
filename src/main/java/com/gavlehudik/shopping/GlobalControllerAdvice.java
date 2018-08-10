package com.gavlehudik.shopping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice
{
    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(true);

        if(session.getAttribute("LoggedIn") != null) {
            model.addAttribute("LoggedIn", true);
        }
        model.addAttribute("session", session);
    }
}
