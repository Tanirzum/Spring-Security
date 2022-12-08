package com.tanirbergen.SecondAppSpringSecurityPage.Controllers;

import com.tanirbergen.SecondAppSpringSecurityPage.Model.Person;
import com.tanirbergen.SecondAppSpringSecurityPage.ServiceDetails.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final PersonService personService;

    @Autowired
    public AuthController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String login() {
        return "Auth/auth";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("person") Person person) {
        return "Auth/register";
    }

    @PostMapping("/register")
    public String save(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/auth/login";
    }
}
