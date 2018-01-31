package blacar.domain.ride;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import blacar.domain.account.Account;

@Entity
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date startDate;
	private List<String> locations;
	private List<Date> arrivalDate;
	private int totalPlaces;
	private int leftPlaces;
	private List<String> caracteristics;
	
	@JsonIgnore
	@ManyToOne
	private Account accountProposed;
	
	
	public Ride() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getTotalPlaces() {
		return totalPlaces;
	}

	public void setTotalPlaces(int totalPlaces) {
		this.totalPlaces = totalPlaces;
	}

	@JsonIgnore
	public Account getAccountProposed() {
		return accountProposed;
	}

	public void setAccountProposed(Account accountProposed) {
		this.accountProposed = accountProposed;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public List<Date> getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(List<Date> arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getLeftPlaces() {
		return leftPlaces;
	}

	public void setLeftPlaces(int leftPlaces) {
		this.leftPlaces = leftPlaces;
	}

	public List<String> getCaracteristics() {
		return caracteristics;
	}

	public void setCaracteristics(List<String> caracteristics) {
		this.caracteristics = caracteristics;
	}
	
	
	
	
	

}
