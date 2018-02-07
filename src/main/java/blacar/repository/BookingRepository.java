package blacar.repository;

import org.springframework.data.repository.CrudRepository;

import blacar.domain.booking.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
