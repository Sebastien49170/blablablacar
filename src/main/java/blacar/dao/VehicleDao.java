package blacar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacar.domain.vehicle.Vehicle;



@Repository
public interface VehicleDao extends CrudRepository<Vehicle, Long> {
    public List<Vehicle> findAllByModel (String model);
}
