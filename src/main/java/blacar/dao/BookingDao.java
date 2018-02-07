package blacar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import blacar.domain.booking.Booking;



@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {
    public List<Booking> findAllByBookId(int bookId);
}
