package blacar.domain.ride;

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
	private Long id;
	private String startDate;
	private String location;
	private String arrivalDate;
	private int totalPlaces;
	private int leftPlaces;
//	@ElementCollection(targetClass=String.class)
//	private List<String> caracteristics;
	
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
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

	public String getLocations() {
		return location;
	}

	public void setLocations(String location) {
		this.location = location;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getLeftPlaces() {
		return leftPlaces;
	}

	public void setLeftPlaces(int leftPlaces) {
		this.leftPlaces = leftPlaces;
	}

//	public List<String> getCaracteristics() {
//		return caracteristics;
//	}
//
//	public void setCaracteristics(List<String> caracteristics) {
//		this.caracteristics = caracteristics;
//	}
	
	
	
	
	

}
