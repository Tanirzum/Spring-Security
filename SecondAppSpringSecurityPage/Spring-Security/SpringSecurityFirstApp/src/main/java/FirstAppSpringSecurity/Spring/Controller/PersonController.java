package FirstAppSpringSecurity.Spring.Controller;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
