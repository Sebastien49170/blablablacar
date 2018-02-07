package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.domain.account.Account;
import blacar.domain.booking.Booking;
import blacar.domain.ride.Ride;
import blacar.repository.AccountRepository;
import blacar.repository.BookingRepository;
import blacar.repository.RideRepository;



@RestController
@RequestMapping("/api/booking")
public class BookingApi {

	@Autowired
	RideRepository rideRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BookingRepository bookingRepository;


	@GetMapping
	public Iterable<Booking> findAll() {
		return bookingRepository.findAll();
	}


	@PostMapping("{aid}/{rid}")
	public void saveBooking(@PathVariable("aid") Long accountId, @PathVariable("rid") Long rideId) {
		Account account = accountRepository.findOne(accountId);
		Ride ride = rideRepository.findOne(rideId);

		Booking booking = new Booking();
		booking.setAccount(account);
		booking.setRide(ride);
		bookingRepository.save(booking);

	}

}