package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blacar.domain.account.Account;
import blacar.domain.booking.Booking;
import blacar.domain.ride.Ride;
import blacar.repository.AccountRepository;
import blacar.repository.BookingRepository;
import blacar.repository.RideRepository;


@Transactional
@Service
public class BookingService {

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    RideRepository rideRepository;
    
    @Autowired
    BookingRepository bookingRepository;
    
   
    public void addBooking(Long accountId, Long rideId) {
    	Account account = accountRepository.findOne(accountId);
    	Ride ride = rideRepository.findOne(rideId);
    	Booking booking = new Booking();
    	
    	booking.setAccount(account);
		booking.setRide(ride);
    	
    	account.getBooking().add(booking);
    	ride.getBooking().add(booking);
    	
    	bookingRepository.save(booking);
    	
    }
   
}