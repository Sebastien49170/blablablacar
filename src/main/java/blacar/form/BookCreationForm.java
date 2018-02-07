package blacar.form;

import javax.validation.constraints.NotNull;

public class BookCreationForm {

	@NotNull
	private String location;
	@NotNull
	private String login;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
