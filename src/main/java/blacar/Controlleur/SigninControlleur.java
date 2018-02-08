package blacar.Controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SigninControlleur {
	
	@RequestMapping("/signin")
    public String signin() {
        return "signin";
    }

}
