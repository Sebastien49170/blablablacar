package blacar.Controlleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import blacar.domain.account.Account;
import blacar.domain.booking.Booking;
import blacar.domain.ride.Ride;
import blacar.form.BookCreationForm;
import blacar.repository.AccountRepository;
import blacar.repository.BookingRepository;
import blacar.repository.RideRepository;
import blacar.service.AccountService;
import blacar.service.RideService;

@Controller
public class BookingCreationController extends WebMvcConfigurerAdapter {
	
	@Autowired
	RideService rideService;
	@Autowired
	RideRepository rideRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	BookingRepository bookingRepository;

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/bookcreation/results").setViewName("results");
    }

    @GetMapping("/bookcreation")
    public String showForm(Ride ride, BookCreationForm form,@RequestParam(name = "search", required = false) String search, Model model) {
    	
    	Iterable<Ride> rides;
  
    	if (search != null && !search.isEmpty()) {
                rides = rideRepository.findAllByToCityLikeIgnoreCaseOrFromCityLikeIgnoreCase("%" + search + "%", "%" + search + "%");
    	}
    	else {
    		rides = rideRepository.findAll();
    	}
       
          model.addAttribute("rides", rides);
          model.addAttribute("search", search);
         	
        return "bookcreation";
    }
    
    @PostMapping("/bookcreation")
    public String checkBookingInfo(@Valid BookCreationForm bookForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
        	System.out.println("erreur form book");
            return "bookcreation";
        }
        else {
        	String log;
        	Account account = new Account();
        	Ride ride = new Ride();
        	Booking booking = new Booking();
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            log = auth.getName();

            System.out.println(log);
        	
        	ride = rideRepository.findOne(bookForm.getRideId());
        	account = accountRepository.findByLogin(log);
        	
        	if(ride.getSeats()<=0) {
        		model.addAttribute("message", "Plus de places disponibles.");
        	}
        	else {
           	booking.setRide(ride);
           	ride.setSeats((short) (ride.getSeats()-1));           	
           	booking.setAccount(account);
        	   	     	
           	bookingRepository.save(booking);
           	model.addAttribute("message", "Booking effectue");
        	}
        	
           	Iterable<Ride> rides = rideRepository.findAll();
            model.addAttribute("rides", rides);
        	
        	return "bookCreation";
        }
    }

}
