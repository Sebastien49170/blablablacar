package blacar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blacar.domain.vehicle.Vehicle;
import blacar.repository.VehicleRepository;



@Service
public class VehicleService {

	 @Autowired
	 VehicleRepository vehicleRepository;

    public void add(Vehicle vehicle) {
    	vehicleRepository.save(vehicle);
    }
}