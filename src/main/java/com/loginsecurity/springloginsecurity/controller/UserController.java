package com.loginsecurity.springloginsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(path = "user")
public class UserController {
@GetMapping("protect")
public String endpoi() {
    
    return "como vc mandou isso";
}

}
