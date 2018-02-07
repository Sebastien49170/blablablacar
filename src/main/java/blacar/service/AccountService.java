package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.domain.account.Account;
import blacar.domain.ride.Ride;
import blacar.domain.vehicle.Vehicle;
import blacar.repository.AccountRepository;
import blacar.repository.RideRepository;
import blacar.repository.VehicleRepository;



@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    RideRepository rideRepository;
    
    @Autowired
    VehicleRepository vehicleRepository;
    
        

    public void signup(Account account) {
    	accountRepository.save(account);
    }
    
    public void addVehicleToUser(Long accountId, Long vehiculeId) {
    	Account account = accountRepository.findOne(accountId);
    	Vehicle vehicle = vehicleRepository.findOne(vehiculeId);
    	account.getVehicle().add(vehicle);
    	vehicle.setAccount(account);
    	accountRepository.save(account);
    }
    
    public void addRideToUser(Long accountId, Long rideId) {
    	Account account = accountRepository.findOne(accountId);
    	Ride ride = rideRepository.findOne(rideId);
    	account.getProposedRide().add(ride);
    	ride.setAccountProposed(account);
    	accountRepository.save(account);
    }
}