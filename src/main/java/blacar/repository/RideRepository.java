package blacar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import blacar.domain.ride.Ride;

public interface RideRepository extends CrudRepository<Ride, Long>{
	public Ride findByFromCity(String fromCity);
	public List<Ride> findAllByToCityLikeIgnoreCaseOrFromCityLikeIgnoreCase(String toCity, String fromCity);
}
