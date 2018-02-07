package blacar.Controlleur;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String showForm(BookCreationForm form) {
        return "bookcreation";
    }

    @PostMapping("/bookcreation")
    public String checkBookingInfo(@Valid BookCreationForm bookForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "bookcreation";
        }
        else {
        	
        	Account account = new Account();
        	Ride ride = new Ride();
        	Booking booking = new Booking();
        	
        	ride = rideRepository.findByFromCity(bookForm.getLocation());
        	account = accountRepository.findByLogin(bookForm.getLogin());

           	booking.setRide(ride);
           	booking.setAccount(account);
        	    	     	
           	bookingRepository.save(booking);
        	
        	return "bookCreation";
        }
    }

}
