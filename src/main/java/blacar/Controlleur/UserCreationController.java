package blacar.Controlleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import blacar.domain.account.Account;
import blacar.form.UserCreationForm;
import blacar.repository.AccountRepository;
import blacar.service.AccountService;

@Controller
public class UserCreationController extends WebMvcConfigurerAdapter {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
    private AccountRepository accountRepository;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(UserCreationForm form) {
        return "signup";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid UserCreationForm personForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            return "signup";
        }
        
        if(accountRepository.findByLogin(personForm.getLogin())!=null) {
        	model.addAttribute("error","Cet utilisateur existe deja");
        	return "signup";
        }
        else {
        	Account account = new Account();
        	account.setLogin(personForm.getLogin());
        	account.setPassword(personForm.getPassword());
        	
        	accountService.signup(account);
        	
        	redirectAttributes.addAttribute("accountId", account.getId());
            return "redirect:/home";
        }
    }
    
    @GetMapping("/home")
    public String home(@ModelAttribute("accountId") Long accountId, Model model) {
        Account account = accountRepository.findOne(accountId);
        model.addAttribute("account", account);
        return "home";
    }

}
