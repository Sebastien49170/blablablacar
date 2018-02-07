package blacar.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RideCreationForm {
	
	private Long accountId;
	
	private String fromCity;
	private String toCity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date startDate;
	
	private Double cost;
	
	private short seats;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	

	
	
	
	
}
