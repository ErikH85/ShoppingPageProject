package com.gavlehudik.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    public class RFController {

        @Autowired
        private RFRepository rfRepository;

        @PostMapping("/register")
        public String postRegister(@RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam String firstname,
                                   @RequestParam String lastname,
                                   @RequestParam String address,
                                   @RequestParam String zipcode,
                                   @RequestParam String city,
                                   @RequestParam String country) {

            if (rfRepository.addUser(email, password, firstname, lastname,
                    address, zipcode, city, country)) {
                rfRepository.addAddresses(email, address);
                return "index";
            }
            return "index";
        }

    }