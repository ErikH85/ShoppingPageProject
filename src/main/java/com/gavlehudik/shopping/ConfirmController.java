package com.gavlehudik.shopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmController {


    @GetMapping("/confirm")
    public String getConfirmPage(){
        return "confirm";
    }
}
