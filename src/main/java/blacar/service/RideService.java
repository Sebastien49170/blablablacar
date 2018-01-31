package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.dao.RideDao;
import blacar.domain.ride.Ride;



@Service
public class RideService {

    @Autowired
    RideDao rideDao;

    public void add(Ride ride) {
    	rideDao.save(ride);
    }
}