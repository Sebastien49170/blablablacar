package blacar.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
    
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    
        

    public void signup(Account account) {
    	accountRepository.save(account);
    	try {
    		System.out.println("Boucle signup");
            inMemoryUserDetailsManager.createUser(new org.springframework.security.core.userdetails.User(account.getLogin(), account.getPassword(), new ArrayList<GrantedAuthority>()));
        } catch (Exception e) {
            e.printStackTrace();
        }
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