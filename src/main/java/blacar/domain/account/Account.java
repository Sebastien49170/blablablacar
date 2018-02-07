package blacar.domain.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import blacar.domain.booking.Booking;
import blacar.domain.ride.Ride;
import blacar.domain.vehicle.Vehicle;


@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

	@NotBlank
	private String login;

	@NotBlank
	private String password;

	private String firstName;
	
	private String lastName;

	@JsonFormat(pattern="YYYY:MM:DD")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	private int rating;
	
	private Boolean confirmed = false;

	@OneToMany(mappedBy="accountVehicle")
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	@OneToMany(mappedBy="accountProposed")
	private List<Ride> proposedRide = new ArrayList<Ride>();
	
	@OneToMany(mappedBy="account")
	private List<Booking>booking;


	public Account() {
		super();
	}

	public List<Ride> getProposedRide() {
		return proposedRide;
	}

	public void setProposedRide(List<Ride> proposedRide) {
		this.proposedRide = proposedRide;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
		
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	


}
