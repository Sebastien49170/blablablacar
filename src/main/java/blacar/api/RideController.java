package blacar.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blacar.dao.RideDao;
import blacar.domain.ride.Ride;
import blacar.service.RideService;



@RestController
@RequestMapping("/ride")
public class RideController {

	@Autowired
	RideDao rideDao;
	
	@Autowired
	RideService rideService;
	
	@GetMapping("show/{idRide}")
    public Ride find(@PathVariable("idRide") Long idRide) {
        return rideDao.findOne(idRide);
    }

    @GetMapping
    public Iterable<Ride> findAll() {
        return rideDao.findAll();
    }

    @PostMapping
    public void add(@RequestBody Ride ride) {
       rideService.add(ride);
    }
}