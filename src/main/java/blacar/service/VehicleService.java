package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.dao.VehicleDao;
import blacar.domain.vehicle.Vehicle;



@Service
public class VehicleService {

    @Autowired
    VehicleDao vehicleDao;

    public void add(Vehicle vehicle) {
    	vehicleDao.save(vehicle);
    }
}