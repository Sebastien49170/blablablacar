package blacar.Controlleur;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import blacar.domain.account.Account;
import blacar.domain.ride.Ride;
import blacar.form.RideCreationForm;
import blacar.repository.AccountRepository;
import blacar.repository.RideRepository;
import blacar.service.RideService;

@Controller
public class RideCreationController extends WebMvcConfigurerAdapter {
	
	@Autowired
	RideService rideService = new RideService();
	
    @Autowired
    private RideRepository rideRepository;
    
    @Autowired
    private AccountRepository accountRepository;
	
	
    @GetMapping("/ride")
    public String showForm(Account account, RideCreationForm form,  @RequestParam(name = "ride", required = false) String rideId, Model model) {
    	if (rideId != null && !rideId.isEmpty()) {
            Ride ride = rideRepository.findOne(Long.valueOf(rideId));
            model.addAttribute("ride", ride);
        }
        Iterable<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
  
        return "rideCreation";
    }

    @PostMapping("/ride")
    public String checkRideInfo(@Valid RideCreationForm rideForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "rideCreation";
        }
        else {
        	//Date convertedDateMinutePrecision = DateUtils.convert(rideForm.getStartDate(), rideForm.getStartHours(), rideForm.getStartMinute());
            
        	Date convertedDateMinutePrecision = rideForm.getStartDate();
        	
        	
        	rideService.add(convertedDateMinutePrecision, rideForm.getFromCity(), rideForm.getToCity(), rideForm.getCost(), rideForm.getSeats(), rideForm.getAccountId());
            model.addAttribute("message", "Votre trajet a bien été pris en compte.");
  
        	
        	return "rideCreation";
        }
    } 
        @GetMapping("list")
        public String list(Model model) {
            Iterable<Ride> rides = rideRepository.findAll();

            model.addAttribute("rides", rides);
            return "ridelist";
        }
    }


