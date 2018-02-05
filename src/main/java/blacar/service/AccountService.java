package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.dao.AccountDao;
import blacar.dao.RideDao;
import blacar.dao.VehicleDao;
import blacar.domain.account.Account;
import blacar.domain.ride.Ride;
import blacar.domain.vehicle.Vehicle;



@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;
    
    @Autowired
    VehicleDao vehicleDao;
    
    @Autowired
    RideDao rideDao;
    

    public void signup(Account account) {
        accountDao.save(account);
    }
    
    public void addVehicleToUser(Long accountId, Long vehiculeId) {
    	Account account = accountDao.findOne(accountId);
    	Vehicle vehicle = vehicleDao.findOne(vehiculeId);
    	account.getVehicle().add(vehicle);
    	vehicle.setAccount(account);
    	accountDao.save(account);
    }
    
    public void addRideToUser(Long accountId, Long vehiculeId) {
    	Account account = accountDao.findOne(accountId);
    	Ride ride = rideDao.findOne(vehiculeId);
    	account.getProposedRide().add(ride);
    	ride.setAccountProposed(account);
    	accountDao.save(account);
    }
}