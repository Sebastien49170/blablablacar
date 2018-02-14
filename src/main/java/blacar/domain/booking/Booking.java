package blacar.domain.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import blacar.domain.account.Account;
import blacar.domain.ride.Ride;


@Entity
public class Booking {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	
	@JsonIgnore
	@ManyToOne
	private Account account;
	
	@JsonIgnore
	@ManyToOne
	private Ride ride;
	
	private int seatCount;
	
		
	public Booking() {
		super();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Ride getRide() {
		return ride;
	}


	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}
	
	
}
