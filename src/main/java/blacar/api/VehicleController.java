package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.dao.VehicleDao;
import blacar.domain.vehicle.Vehicle;
import blacar.service.VehicleService;



@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleDao vehicleDoa;
	
	
	@GetMapping("{id}")
    public Vehicle find(@PathVariable("id") Long vehicleId) {
        return vehicleDoa.findOne(vehicleId);
    }

    @GetMapping
    public Iterable<Vehicle> findAll() {
        return vehicleDoa.findAll();
    }

    @PostMapping
    public void add(@RequestBody Vehicle vehicle) {
        vehicleService.add(vehicle);
    }
}