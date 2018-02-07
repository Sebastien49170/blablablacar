package blacar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacar.domain.vehicle.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{

}
