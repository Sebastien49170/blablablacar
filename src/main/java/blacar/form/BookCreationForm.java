package blacar.form;

import javax.validation.constraints.NotNull;

public class BookCreationForm {

	
//	private String fromCity;
	@NotNull
	private String login;
	
	private Long rideId;
	
	
	public Long getRideId() {
		return rideId;
	}
	public void setRideId(Long rideId) {
		this.rideId = rideId;
	}
//	public String getFromCity() {
//		return fromCity;
//	}
//	public void setFromCity(String fromCity) {
//		this.fromCity = fromCity;
//	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	
	
}
