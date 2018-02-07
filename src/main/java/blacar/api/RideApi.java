package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.domain.ride.Ride;
import blacar.repository.RideRepository;



@RestController
@RequestMapping("/api/ride")
public class RideApi {

	 @Autowired
	 private RideRepository rideRepository;
	
	@GetMapping("show/{idRide}")
    public Ride find(@PathVariable("idRide") Long idRide) {
        return rideRepository.findOne(idRide);
    }

    @GetMapping
    public Iterable<Ride> findAll() {
        return rideRepository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Ride ride) {
    	rideRepository.save(ride);
    }
}