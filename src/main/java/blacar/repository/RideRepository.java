package blacar.repository;

import org.springframework.data.repository.CrudRepository;

import blacar.domain.ride.Ride;

public interface RideRepository extends CrudRepository<Ride, Long>{
	public Ride findByFromCity(String fromCity);
}
