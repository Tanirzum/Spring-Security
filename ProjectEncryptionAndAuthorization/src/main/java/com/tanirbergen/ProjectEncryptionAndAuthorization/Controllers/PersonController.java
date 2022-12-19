package com.tanirbergen.ProjectEncryptionAndAuthorization.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
