package tn.esprit.beautifulminds.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User extends Person implements Serializable {

	private String email;
	private String passwd;
	private Boolean Vip;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Boolean getVip() {
		return this.Vip;
	}

	public void setVip(Boolean Vip) {
		this.Vip = Vip;
	}

}
