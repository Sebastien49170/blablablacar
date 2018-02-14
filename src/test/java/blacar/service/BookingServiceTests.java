package blacar.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import blacar.domain.account.Account;
import blacar.domain.ride.Ride;
import blacar.repository.AccountRepository;
import blacar.repository.BookingRepository;
import blacar.repository.RideRepository;
import blacar.service.AccountService;
import blacar.service.BookingService;
import blacar.service.RideService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTests {
	

	 	@Autowired
	    private AccountService accountService;
	 	
	 	@Autowired
	 	private AccountRepository accountRepository;
	 	
	 	@Autowired
	 	private RideService rideService;
	    
	    @Autowired
	    private RideRepository rideRepository;
	    
	    @Autowired
	    private BookingRepository bookingRepository;
	    
	    @Autowired
	    private BookingService bookingService;
	    
	    
	@Test
	public void canBookAride() {
		
		short seat = 1;
		Account account = new Account();
		
		account.setLogin("login");
		account.setPassword("password");
		accountService.signup(account);
		
		
		
		Ride ride = rideService.add(new Date(), "Angers", "Marseille", 10.0, seat, account.getId());
		
		bookingService.addBooking(account.getId(), ride.getId());
		
	//	assertThat(accountRepository.findByLogin(account.getLogin()).getBooking().size().isEqualTo(0));
	//	assertThat(rideRepository.findOne(ride.getId()).getSeats()).isEqualTo((short) (seat - 1));
       		
	}
}

