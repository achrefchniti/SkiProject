package tn.esprit.beautifulminds.tests;

import java.text.ParseException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.beautifulminds.persistence.Shop;
import tn.esprit.beautifulminds.services.crud.ShopServicesRemote;

public class TestDeleteShop {

	public static void main(String[] args) throws NamingException, ParseException {
		Context context = new InitialContext();
		ShopServicesRemote ShopServicesRemote = (ShopServicesRemote) context
				.lookup("SkiWorld-ear/SkiWorld-ejb/ShopServices!tn.esprit.beautifulminds.services.crud.ShopServicesRemote");

		Shop shop = ShopServicesRemote.findShopById(2);
		ShopServicesRemote.deleteShop(shop);

	}
}
