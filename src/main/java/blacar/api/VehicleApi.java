package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.domain.vehicle.Vehicle;
import blacar.repository.VehicleRepository;
import blacar.service.VehicleService;



@RestController
@RequestMapping("/api/vehicle")
public class VehicleApi {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	
	@GetMapping("{id}")
    public Vehicle find(@PathVariable("id") Long vehicleId) {
        return vehicleRepository.findOne(vehicleId);
    }

    @GetMapping
    public Iterable<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Vehicle vehicle) {
        vehicleService.add(vehicle);
    }
}