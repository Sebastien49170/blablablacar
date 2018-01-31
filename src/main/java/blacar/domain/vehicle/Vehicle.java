package blacar.domain.vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import blacar.domain.account.Account;


@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String model;

	private Integer yearOfBuilding;
	
	
	@ManyToOne
	private Account accountVehicle;

	public Vehicle() {
		super();
	}
	
	@JsonIgnore
	public Account getAccount() {
		return accountVehicle;
	}

	public void setAccount(Account account) {
		this.accountVehicle = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYearOfBuilding() {
		return yearOfBuilding;
	}

	public void setYearOfBuilding(Integer yearOfBuilding) {
		this.yearOfBuilding = yearOfBuilding;
	}
}
