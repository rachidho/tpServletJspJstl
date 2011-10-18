package fr.shopping.bean;

public class Produit {
	
	// id de produit
	private String id;
	// nom de produit
	private String nom;
	// prix de produit
	private float prix;
	// description sur le produit
	private String description;
	// image de produit
	private String image;
	
	
	public Produit() {
	}


	/*
	 * les getters et les setters
	 */
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	

}
