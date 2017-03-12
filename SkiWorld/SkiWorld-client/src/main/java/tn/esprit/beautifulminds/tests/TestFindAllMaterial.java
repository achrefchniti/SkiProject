package tn.esprit.beautifulminds.tests;

import java.text.ParseException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Material;
import tn.esprit.beautifulminds.services.crud.MaterialServicesRemote;

public class TestFindAllMaterial {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		MaterialServicesRemote MaterialServicesRemote = (MaterialServicesRemote) context.lookup(
				"SkiWorld-ear/SkiWorld-ejb/MaterialServices!tn.esprit.beautifulminds.services.crud.MaterialServicesRemote");

		List<Material> material = MaterialServicesRemote.findAllMaterials();

		for (Material m : material) {
			System.out.println(m.getMaterialId());
			System.out.println(m.getFournisseur());
		}
	}

}
