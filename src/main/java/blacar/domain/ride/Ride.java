package blacar.domain.ride;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import blacar.domain.account.Account;
import blacar.domain.booking.Booking;

@Entity
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	

	private String fromCity;
	private String toCity;

	private Double cost;

	private short seats;
	
		
	@OneToMany(mappedBy = "ride")
	private List<Booking>booking = new ArrayList<Booking>();

	@JsonIgnore
	@ManyToOne
	private Account accountProposed;
	
	
	public Ride() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public String getFromCity() {
		return fromCity;
	}


	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}


	public String getToCity() {
		return toCity;
	}


	public void setToCity(String toCity) {
		this.toCity = toCity;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public short getSeats() {
		return seats;
	}


	public void setSeats(short seats) {
		this.seats = seats;
	}


	public List<Booking> getBooking() {
		return booking;
	}


	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}


	public Account getAccountProposed() {
		return accountProposed;
	}


	public void setAccountProposed(Account accountProposed) {
		this.accountProposed = accountProposed;
	}
	
	
}
	

	
