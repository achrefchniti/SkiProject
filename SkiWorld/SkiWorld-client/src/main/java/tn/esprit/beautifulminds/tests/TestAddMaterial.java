package tn.esprit.beautifulminds.tests;

import java.text.ParseException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Material;
import tn.esprit.beautifulminds.services.crud.MaterialServicesRemote;

public class TestAddMaterial {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		MaterialServicesRemote MaterialServicesRemote = (MaterialServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/MaterialServices!tn.esprit.beautifulminds.services.crud.MaterialServicesRemote");

		Material mat = new Material();

		mat.setFournisseur("zidi materials");

		MaterialServicesRemote.addMaterial(mat);

	}

}
