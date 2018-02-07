package blacar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacar.domain.ride.Ride;

@Repository
public interface RideDao extends CrudRepository<Ride, Long> {
	 public List<Ride> findAllByFromCity(String fromCity);

}