package blacar.controlleur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class BlacarControlleur extends WebMvcConfigurerAdapter {
	

    @GetMapping({"/blacar","/"})
    public String showForm() {
    	        	
        return "blacar";
    }
    
    
    
    

   

}
