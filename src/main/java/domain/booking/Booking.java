package domain.booking;

import java.util.Date;

import domain.account.Account;

public class Booking {
	
	private Account login;
	private int rideId;
	private int seatCount;
	private Date dateCreation;
	
	
	
	public Booking() {
		super();
	}

	public Account getLogin() {
		return login;
	}

	public void setLogin(Account login) {
		this.login = login;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	

}
