package blacar.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.domain.account.Account;
import blacar.domain.ride.Ride;
import blacar.repository.AccountRepository;
import blacar.repository.RideRepository;



@Service
public class RideService {

	@Autowired
	RideRepository rideRepository;

	@Autowired
	AccountRepository accountRepository;


	public void add(Date startDate, String fromCity, String toCity, Double cost, short seats, Long accountId ) {
		Ride ride = new Ride();

		ride.setStartDate(startDate);
		ride.setFromCity(fromCity);
		ride.setToCity(toCity);
		ride.setCost(cost);
		ride.setSeats(seats);
		Account account= accountRepository.findOne(accountId);
		ride.setAccountProposed(account);		

		rideRepository.save(ride);
	}

}