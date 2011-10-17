package fr.shopping.bean;

import java.util.HashMap;

public class Catalogue {

	private static Catalogue catalogue;
	private String name;
	private HashMap<String ,Produit> listProduit;
	
	public Catalogue() {
	}
	
	public static Catalogue getInstance(){
		if(catalogue == null){
			catalogue = new Catalogue();
		}
		return catalogue;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public HashMap<String, Produit> getListProduit() {
		return listProduit;
	}


	public void setListProduit(HashMap<String, Produit> listProduit) {
		this.listProduit = listProduit;
	}

	
}
