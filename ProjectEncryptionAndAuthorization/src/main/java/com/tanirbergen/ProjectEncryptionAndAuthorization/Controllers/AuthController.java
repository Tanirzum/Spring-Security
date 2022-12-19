package com.tanirbergen.ProjectEncryptionAndAuthorization.Controllers;

import com.tanirbergen.ProjectEncryptionAndAuthorization.Model.Person;
import com.tanirbergen.ProjectEncryptionAndAuthorization.ServiceUserDetails.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonService personService;

    public AuthController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String hello() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("person") Person person) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String save(@ModelAttribute("person") Person person) {
        return "redirect:/auth/login";
    }
}
