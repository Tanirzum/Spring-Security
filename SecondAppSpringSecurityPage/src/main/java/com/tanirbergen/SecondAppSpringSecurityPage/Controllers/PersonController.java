package com.tanirbergen.SecondAppSpringSecurityPage.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
