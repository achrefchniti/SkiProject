package tn.esprit.beautifulminds.presentation;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.beautifulminds.persistence.User;
import tn.esprit.beautifulminds.services.other.SignInServicesLocal;

@ManagedBean
@SessionScoped
public class Identity {
	@EJB
	private SignInServicesLocal signinlocal;
	private Boolean clientloggedIn = false;
	private User client = new User();
	private boolean isLogged = false;

	

	public String doSignIn() {
		String navigateTo = "";
		User userLoggedIn = signinlocal.login(client.getEmail(), client.getPassword());
		if (userLoggedIn != null) {
			client = userLoggedIn;
			clientloggedIn = true;
			navigateTo = "/pages/client/me?faces-redirect=true";
		} else {
			System.err.println("not");
		}
		return navigateTo;
	}

	public Boolean getClientloggedIn() {
		return clientloggedIn;
	}

	public void setClientloggedIn(Boolean clientloggedIn) {
		this.clientloggedIn = clientloggedIn;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	public String logout() {
		isLogged = true;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}
	
}
